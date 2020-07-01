package ru.afal.alfabattle.dal.atm;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;

/**
 * @author Fal.
 */
public interface FilterRepository {
    @NotNull Optional<WebSocketFilter> getFilter();
}
