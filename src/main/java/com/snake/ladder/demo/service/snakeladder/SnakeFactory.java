package com.snake.ladder.demo.service.snakeladder;


import com.snake.ladder.demo.models.GameElement;
import com.snake.ladder.demo.service.elements.Snake;
import com.snake.ladder.demo.utils.Utils;

import java.awt.*;

public class SnakeFactory {
    private static SnakeFactory INSTANCE;

    private SnakeFactory() {
    }

    public static SnakeFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (SnakeFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SnakeFactory();
                }
            }
        }
        return INSTANCE;
    }

    public GameElement getRandomSnake(int boardWidth, int boardHeight) {
        Point start = Utils.generatePoint(boardWidth, boardHeight);
        Point end = Utils.generatePoint(start.getX(), start.getY(), boardWidth, boardHeight);
        return new Snake(start, end);
    }
}
