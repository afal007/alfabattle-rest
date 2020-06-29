package ru.afal.alfabattle.usecase.mapper;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabank.atmapi.model.ATMDetails;
import ru.afal.alfabattle.api.AtmLocation;

public interface AtmMapper {
    @NotNull AtmLocation map(@NotNull ATMDetails atmDetails);
}
