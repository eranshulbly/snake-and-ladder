package com.snake.ladder.demo.service.events;

import com.snake.ladder.demo.models.GameEventData;
import com.snake.ladder.demo.models.Move;

public class MoveMade implements GameEventData {
    private Move move;

    public MoveMade(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Move was made " + move.toString();
    }
}
