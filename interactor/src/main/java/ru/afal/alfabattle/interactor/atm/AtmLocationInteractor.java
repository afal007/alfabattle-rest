package ru.afal.alfabattle.interactor.atm;

import org.jetbrains.annotations.NotNull;

import ru.afal.alfabattle.api.atm.AtmLocation;
import ru.afal.alfabattle.interactor.gateway.atm.PaymentMode;

/**
 * Interactor for locating ATMs by parameters.
 *
 * @author Fal.
 */
public interface AtmLocationInteractor {
    /**
     * Find ATM location by ID.
     *
     * @param deviceID ATM device ID.
     *
     * @return ATM location.
     *
     * @throws AtmNotFoundException if ATM with given deviceID was not found.
     */
    @NotNull AtmLocation findAtmByID(int deviceID) throws AtmNotFoundException;

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
