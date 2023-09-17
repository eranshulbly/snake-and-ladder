package com.snake.ladder.demo.service.snakeladder;

import com.snake.ladder.demo.models.GameElement;
import com.snake.ladder.demo.service.elements.Ladder;
import com.snake.ladder.demo.utils.Utils;

import java.awt.*;

public class LadderFactory {
    private static LadderFactory INSTANCE;

    private LadderFactory() {
    }

    public static LadderFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (LadderFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LadderFactory();
                }
            }
        }
        return INSTANCE;
    }

    public GameElement getRandomLadder(int boardWidth, int boardHeight) {
        Point start = Utils.generatePoint(boardWidth, boardHeight);
        Point end = Utils.generatePoint(start.getX(), start.getY(), boardWidth, boardHeight);
        return new Ladder(start, end);
    }
}
