package com.snake.ladder.demo.exceptions;

public class InvalidMoveException extends GameException{
    public InvalidMoveException(String message) {
        super(message);
    }
}
