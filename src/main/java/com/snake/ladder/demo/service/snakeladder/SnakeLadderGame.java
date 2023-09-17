package com.snake.ladder.demo.service.snakeladder;

import com.snake.ladder.demo.exceptions.InvalidGameStateForActionException;
import com.snake.ladder.demo.exceptions.InvalidMoveException;
import com.snake.ladder.demo.models.*;
import com.snake.ladder.demo.models.Player;
import lombok.Builder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class SnakeLadderGame implements Game {
    private final int snakesCount, laddersCount, boardWidth, boardHeight;
    private final List<Player> players;
    private GameState gameState;
    private TurnTracker turnTracker;
    private Integer playerWithTurn;

    Map<Player, Point> playerLocations;
    List<GameElement> elements;
    @Override
    public void initialize() {
        System.out.println("Initializing Classic Snake Ladder");
        this.elements = new ArrayList<>();
        this.playerLocations = new HashMap<>();
        for (Player player : players) {
            playerLocations.put(player, new Point(0, 0));
        }
        for (int s = 0; s < snakesCount; s++) {
            elements.add(SnakeFactory.getInstance().getRandomSnake(boardWidth, boardHeight));
        }
        for (int s = 0; s < laddersCount; s++) {
            elements.add(LadderFactory.getInstance().getRandomLadder(boardWidth, boardHeight));
        }
        playerWithTurn = 0;
        turnTracker = new RoundRobinTurnTracker(players.size());
        gameState = GameState.STARTED;
        System.out.println("Initialized!");
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public Player getPlayerWithTurn() {
        return players.get(playerWithTurn);
    }

    @Override
    public boolean isValidMove(Move obj) {
        SnakeLadderMove move = (SnakeLadderMove) obj;
        Point location = playerLocations.get(getPlayerWithTurn()); // current player's location
        return (location.getY() != boardHeight - 1)
                || (location.getX() <= boardWidth - move.getRoll());
    }

    @Override
    public void makeMove(Move move) {
        if (!isValidMove(move)) {
            throw new InvalidMoveException("move is not valid");
        }
        System.out.println("Making the move " + move.toString());
        int roll = ((SnakeLadderMove) move).getRoll();
        Player player = getPlayerWithTurn();
        Point location = playerLocations.get(player);
        Point newLocation = new Point(
                (int) ((location.getX() + roll) % boardWidth),
                (int) (location.getY() + ((location.getX() + roll) > boardWidth ? 1 : 0))
        );
        playerLocations.put(player, newLocation);
        if (checkPlayerAtWinningCell(newLocation)) {
            // the current player has won the game!
            gameState = GameState.ENDED;
        } else {
            // make sure that the turn is advanced
            playerWithTurn = turnTracker.getNext();
        }
        // notify all my players
        for (Player p : players) {
            p.notifyMoveMade(move);
        }
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public GameStats getWinningPlayerStats() {
        if (gameState.equals(GameState.ENDED))
            return new SnakeLadderGameStats(players.get(playerWithTurn));
        else
            throw new InvalidGameStateForActionException("Game in progress: winner hasn't been decided yet");
    }

    private boolean checkPlayerAtWinningCell(Point playerLocation) {
        return playerLocation.getX() == boardWidth - 1
                && playerLocation.getY() == boardHeight;
    }
}
