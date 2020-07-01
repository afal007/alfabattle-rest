package ru.afal.alfabattle.dal.atm;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class WebSocketStompFilterRepository implements FilterRepository {

    private final WebSocketStompClient stompClient;
    @Value("${web.socket.url")
    private String webSocketUrl;

    @NotNull
    @Override
    public Optional<WebSocketFilter> getFilter() {
        StompSession stompSession = null;
        Optional<WebSocketFilter> oFilter = Optional.empty();
        try {
            stompSession = stompClient.connect(webSocketUrl, new WebSocketStompSessionHandler()).get();
            Handler handler = new Handler();
            stompSession.subscribe("/destination/message", handler);
            oFilter = Optional.ofNullable(WebSocketFilter.of(handler.get(100, TimeUnit.MILLISECONDS)));
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(stompSession != null && stompSession.isConnected()) {
                stompSession.disconnect();
            }
        }

        return oFilter;
    }

    private static class Handler implements Future<String>, StompFrameHandler {

        private final Object monitor = new Object();

        private volatile String payload;
        private volatile boolean isDone;
        private volatile boolean isRunning;
        private volatile boolean isCanceled;

        @Override
        public @NotNull Type getPayloadType(@NotNull StompHeaders headers) {
            return String.class;
        }

        @Override
        public void handleFrame(@NotNull StompHeaders headers, Object payload) {
            synchronized(monitor) {
                this.payload = (String) payload;
                monitor.notify();
            }
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            if(isCanceled) {
                return false;
            }
            synchronized(monitor) {
                if(isCanceled || !mayInterruptIfRunning && isRunning) {
                    return false;
                }
                isDone = true;
                isCanceled = true;
                monitor.notify();
                return true;
            }
        }

        @Override
        public boolean isCancelled() {
            return isCanceled;
        }

        @Override
        public boolean isDone() {
            return isDone;
        }

        @Override
        public String get() throws InterruptedException {
            if(payload == null && !isCanceled) {
                synchronized(monitor) {
                    if(payload == null && !isCanceled) {
                        isRunning = true;
                        monitor.wait();
                    }
                }
            }

            return payload;
        }

        @Override
        public String get(long timeout, @NotNull TimeUnit unit) throws InterruptedException {
            if(payload == null && !isCanceled) {
                synchronized(monitor) {
                    if(payload == null && !isCanceled) {
                        isRunning = true;
                        monitor.wait(unit.toMillis(timeout));
                    }
                }
            }

            return payload;
        }
    }
}
