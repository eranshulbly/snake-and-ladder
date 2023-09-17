package com.snake.ladder.demo.models;

import com.snake.ladder.demo.models.Move;

public interface Player {
    Move generateMove();

    void notifyMoveMade(Move move);
}
