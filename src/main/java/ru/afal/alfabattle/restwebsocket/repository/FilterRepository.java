package ru.afal.alfabattle.restwebsocket.repository;

import org.jetbrains.annotations.NotNull;
import ru.afal.alfabattle.restwebsocket.model.WebSocketFilter;

import java.util.Optional;

/**
 * @author Fal.
 */
public interface FilterRepository {
  @NotNull
  Optional<WebSocketFilter> getFilter();
}
