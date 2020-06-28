package ru.afal.alfabattle.restwebsocket.service;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.restwebsocket.exception.AtmNotFoundException;
import ru.afal.alfabattle.restwebsocket.model.PaymentMode;

/**
 * Service for locating ATMs by parameters.
 *
 * @author Fal.
 */
public interface AtmLocationService {
    /**
     * Find ATM location by ID.
     *
     * @param deviceID ATM device ID.
     *
     * @return ATM location.
     *
     * @throws AtmNotFoundException if ATM with given deviceID was not found.
     */
    @NotNull AtmLocation findAtmByID(long deviceID) throws AtmNotFoundException;

    /**
     * Find nearest ATM by coordinates and payment mode.
     *
     * @param latitude    latitude.
     * @param longitude   longitude.
     * @param paymentMode payment mode.
     *
     * @return ATM location.
     *
     * @throws AtmNotFoundException if no ATMs with given {@link PaymentMode} were found.
     */
    @NotNull AtmLocation findNearest(
        double latitude, double longitude, @NotNull PaymentMode paymentMode
    ) throws AtmNotFoundException;
}
