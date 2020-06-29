package ru.afal.alfabattle.usecase.repository;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabattle.api.AtmLocation;

public interface AtmLocationRepository {
    @NotNull Optional<AtmLocation> findAtmByID(int deviceID);

    @NotNull List<AtmLocation> findAll();

    @NotNull List<AtmLocation> findAllByPaymentsEnabled(boolean enabled);
}
