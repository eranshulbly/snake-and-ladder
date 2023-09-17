package com.snake.ladder.demo.models;

public interface Game {
    void initialize();

    boolean isOver();

    Player getPlayerWithTurn();

    boolean isValidMove(Move move);

    void makeMove(Move move);

    boolean isDraw();

    GameStats getWinningPlayerStats();
}
