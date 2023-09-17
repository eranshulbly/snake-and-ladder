package com.snake.ladder.demo.service.elements;

import com.snake.ladder.demo.models.ComputerStrategy;
import com.snake.ladder.demo.models.Move;
import com.snake.ladder.demo.models.Player;
import com.snake.ladder.demo.models.User;
import com.snake.ladder.demo.service.snakeladder.SnakeLadderMove;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ComputerPlayer implements Player {
    private final String name, symbol;
    private final ComputerStrategy strategy;

    public ComputerPlayer(String name, String symbol, ComputerStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }


    @Override
    public Move generateMove() {
        int roll = strategy.generate();
        System.out.println(this.toString() + " and I rolled a " + roll);
        return new SnakeLadderMove(roll);
    }

    @Override
    public void notifyMoveMade(Move move) {

    }

    @Override
    public String toString() {
        return "hi, I'm Bot " + name;
    }
}
