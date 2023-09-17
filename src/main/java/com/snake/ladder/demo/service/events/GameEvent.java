package com.snake.ladder.demo.service.events;

import com.snake.ladder.demo.models.GameEventData;
import com.snake.ladder.demo.models.GameEventHandler;

import java.util.ArrayList;
import java.util.List;

public class GameEvent {
    private List<GameEventHandler> handlers;

    public GameEvent() {
        this.handlers = new ArrayList<>();
    }

    public void addListener(GameEventHandler handler) {
        this.handlers.add(handler);
    }

    public void dispatchEvent(GameEventData eventData) {
        for (GameEventHandler hander : handlers) {
            hander.handleEvent(eventData);
        }
    }
}
