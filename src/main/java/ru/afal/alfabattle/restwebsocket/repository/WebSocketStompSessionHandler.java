package ru.afal.alfabattle.restwebsocket.repository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
@MessageMapping
public class WebSocketStompSessionHandler extends StompSessionHandlerAdapter {
}
