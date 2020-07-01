package ru.afal.alfabattle.interactor.gateway.atm;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabattle.api.atm.AtmLocation;

public interface AtmLocationRepository {
    @NotNull Optional<AtmLocation> findAtmByID(int deviceID);

    @NotNull List<AtmLocation> findAll();

    @NotNull List<AtmLocation> findAllByPaymentsEnabled(boolean enabled);
}
