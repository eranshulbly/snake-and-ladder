package com.snake.ladder.demo.service;

import com.snake.ladder.demo.models.Game;
import com.snake.ladder.demo.models.Player;
import com.snake.ladder.demo.service.snakeladder.SnakeLadderGame;

import java.util.List;

public class GameFactory{
    private static GameFactory INSTANCE;
    public GameFactory() {
    }

    public static GameFactory getInstance(){
        if(INSTANCE == null){
            synchronized (GameFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new GameFactory();
                }
            }
        }
        return INSTANCE;
    }


    public Game createClassicSnakeLadder(List<Player> players) {
        return SnakeLadderGame.builder()
                .snakesCount(5)
                .laddersCount(7)
                .boardHeight(10)
                .boardWidth(10)
                .players(players)
                .build();
    }
}
