package ru.afal.alfabattle.dal.atm;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
@MessageMapping
public class WebSocketStompSessionHandler extends StompSessionHandlerAdapter {}
