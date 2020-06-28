package ru.afal.alfabattle.restwebsocket.service;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import ru.afal.alfabattle.restwebsocket.model.WebSocketModel;

import java.lang.reflect.Type;
import java.util.Scanner;

public class SomeWebSocketService implements WebSocketService {
  @Override
  public WebSocketModel doShit() {
    WebSocketClient client = new StandardWebSocketClient();

    WebSocketStompClient stompClient = new WebSocketStompClient(client);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    StompSessionHandler sessionHandler = new StompSessionHandler() {
      @Override
      public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
      }

      @Override
      public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

      }

      @Override
      public void handleTransportError(StompSession session, Throwable exception) {

      }

      @Override
      public Type getPayloadType(StompHeaders headers) {
        return null;
      }

      @Override
      public void handleFrame(StompHeaders headers, Object payload) {

      }
    };
    stompClient.connect("URL", sessionHandler);

    new Scanner(System.in).nextLine(); // Don't close immediately.
    return null;
  }
}
