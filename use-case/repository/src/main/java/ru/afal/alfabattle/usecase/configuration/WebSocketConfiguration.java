package ru.afal.alfabattle.usecase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public MessageConverter messageConverter() {
        return new StringMessageConverter();
    }

    @Bean
    public WebSocketClient standardWebSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketStompClient webSocketStompClient(WebSocketClient webSocketClient, MessageConverter messageConverter) {
        WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
        webSocketStompClient.setMessageConverter(messageConverter);
        return webSocketStompClient;
    }
}
