package com.snake.ladder.demo.exceptions;

public class InvalidBoardSizeException extends ValidationException{
    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
