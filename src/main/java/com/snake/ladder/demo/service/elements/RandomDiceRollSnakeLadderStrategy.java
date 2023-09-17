package com.snake.ladder.demo.service.elements;

import com.snake.ladder.demo.models.ComputerStrategy;

public class RandomDiceRollSnakeLadderStrategy implements ComputerStrategy {
    @Override
    public int generate() {
        return (int) (Math.random() * 6);
    }
}
