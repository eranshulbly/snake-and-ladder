package com.snake.ladder.demo.controller;

import com.snake.ladder.demo.models.*;
import com.snake.ladder.demo.service.events.GameEvent;
import com.snake.ladder.demo.service.events.MoveMade;

public class GameController{
    private final Game game;
    private final GameEvent event;
    public GameController(Game game) {
        this.game = game;
        this.event = new GameEvent();
    }

    public void startGame() {
        game.initialize();
        while (!game.isOver()){
            Player player = game.getPlayerWithTurn();
            Move move;
            do{
                move = player.generateMove();
            }while (!game.isValidMove(move));
            game.makeMove(move);
            event.dispatchEvent(new MoveMade(move));
        }

        if(game.isDraw()){
            System.out.println("Game was a draw");
        }else {
            GameStats winnerStats = game.getWinningPlayerStats();
            System.out.println("Game was won by: " + winnerStats.toString());
        }
    }
    public void addAudience(Audience audience) {
        event.addListener(audience.getGameEventHandler());
    }
}
