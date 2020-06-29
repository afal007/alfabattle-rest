package ru.afal.alfabattle.usecase.repository;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabattle.usecase.model.WebSocketFilter;

/**
 * @author Fal.
 */
public interface FilterRepository {
    @NotNull Optional<WebSocketFilter> getFilter();
}
