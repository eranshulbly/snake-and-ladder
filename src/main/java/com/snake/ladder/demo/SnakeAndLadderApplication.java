package com.snake.ladder.demo;

import com.snake.ladder.demo.controller.GameController;
import com.snake.ladder.demo.models.Audience;
import com.snake.ladder.demo.models.User;
import com.snake.ladder.demo.service.elements.ComputerPlayer;


import com.snake.ladder.demo.service.elements.HumanPlayer;
import com.snake.ladder.demo.models.Player;
import com.snake.ladder.demo.models.Game;
import com.snake.ladder.demo.service.GameFactory;
import com.snake.ladder.demo.service.elements.RandomDiceRollSnakeLadderStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnakeAndLadderApplication.class, args);

        User user1 = new User("Anshul");
        User user2 = new User("Anshul2");
        Audience a1 = new Audience("abc");
        Audience a2 = new Audience("xyz");

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(user1, "blue"));
        players.add(new HumanPlayer(user2, "red"));
        players.add(new ComputerPlayer("Bot1", "green", new RandomDiceRollSnakeLadderStrategy()));
        Game game = GameFactory.getInstance().createClassicSnakeLadder(players);
        GameController controller = new GameController(game);
        controller.addAudience(a1);
        controller.addAudience(a2);
        controller.startGame();

    }

}
