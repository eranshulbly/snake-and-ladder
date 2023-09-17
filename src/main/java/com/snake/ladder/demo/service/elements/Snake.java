package com.snake.ladder.demo.service.elements;

import com.snake.ladder.demo.models.GameElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Snake implements GameElement {
    private final Point start, end;
    public Snake(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

}
