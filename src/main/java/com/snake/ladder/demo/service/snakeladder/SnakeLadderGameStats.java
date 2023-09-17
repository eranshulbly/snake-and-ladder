package com.snake.ladder.demo.service.snakeladder;

import com.snake.ladder.demo.models.GameStats;
import com.snake.ladder.demo.models.Player;

public class SnakeLadderGameStats implements GameStats {
    private Player player;

    public SnakeLadderGameStats(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
