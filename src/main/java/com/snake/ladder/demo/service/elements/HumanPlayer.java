package com.snake.ladder.demo.service.elements;

import com.snake.ladder.demo.models.Move;
import com.snake.ladder.demo.models.User;
import com.snake.ladder.demo.models.Player;
import com.snake.ladder.demo.service.snakeladder.SnakeLadderMove;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HumanPlayer implements Player {
    private User user;
    private String symbol;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public HumanPlayer(User user, String symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    @Override
    public Move generateMove() {
        int roll = 0;
        try{
            System.out.println("Dear " + user.getName() + " please roll the dice: ");
            roll = Integer.parseInt(br.readLine());
        } catch (IOException ignored) {}

        System.out.println(this.toString() + " and I rolled a " + roll);
        return new SnakeLadderMove(roll);
    }

    @Override
    public void notifyMoveMade(Move move) {
        System.out.println("Hi, I'm " + user.getName() + " and I observed the move " + move);
    }
    @Override
    public String toString() {
        return "hi, I'm " + user.getName();
    }
}
