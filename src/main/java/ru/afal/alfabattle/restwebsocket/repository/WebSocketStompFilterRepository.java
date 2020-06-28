package ru.afal.alfabattle.restwebsocket.repository;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import ru.afal.alfabattle.restwebsocket.model.WebSocketFilter;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Repository
@RequiredArgsConstructor
public class WebSocketStompFilterRepository implements FilterRepository {

  public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

  @Value("${web.socket.url")
  private String webSocketUrl;

  private final WebSocketStompClient stompClient;

  @NotNull
  @Override
  public Optional<WebSocketFilter> getFilter() {
    StompSession stompSession = null;
    Optional<WebSocketFilter> oFilter = Optional.empty();
    try {
      stompSession = stompClient.connect("ws://localhost:8081/websocket", new WebSocketStompSessionHandler()).get();
      Handler handler = new Handler();
      stompSession.subscribe("/destination/message", handler);
      String o = (String) EXECUTOR_SERVICE.submit(handler).get();
      oFilter = Optional.ofNullable(WebSocketFilter.of(o));
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      if (stompSession != null && stompSession.isConnected()) {
        stompSession.disconnect();
      }
    }

    return oFilter;
  }

  private static class Handler implements Callable<Object>, StompFrameHandler {

    private final Object monitor = new Object();

    private volatile Object payload;

    @Override
    public Type getPayloadType(StompHeaders headers) {
      return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
      synchronized (monitor) {
        this.payload = payload;
        monitor.notify();
      }
    }

    @Override
    public Object call() throws Exception {
      if (payload == null) {
        synchronized (monitor) {
          if (payload == null) {
            monitor.wait(10000L);
          }
        }
      }

      return payload;
    }
  }
}
