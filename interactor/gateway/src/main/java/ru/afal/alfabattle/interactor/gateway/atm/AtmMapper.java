package ru.afal.alfabattle.interactor.gateway.atm;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabank.atmapi.atm.ATMDetails;
import ru.afal.alfabattle.api.atm.AtmLocation;

public interface AtmMapper {
    @NotNull AtmLocation map(@NotNull ATMDetails atmDetails);
}
