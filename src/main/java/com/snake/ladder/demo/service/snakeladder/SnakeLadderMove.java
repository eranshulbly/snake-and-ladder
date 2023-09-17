package com.snake.ladder.demo.service.snakeladder;

import com.snake.ladder.demo.models.Move;

public class SnakeLadderMove implements Move {
    private final int roll;

    public SnakeLadderMove(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "SnakeLadderMove(" + roll + ")";
    }
}
