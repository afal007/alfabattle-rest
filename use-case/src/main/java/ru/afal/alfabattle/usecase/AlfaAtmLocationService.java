package ru.afal.alfabattle.usecase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.usecase.exception.AtmNotFoundException;
import ru.afal.alfabattle.usecase.model.PaymentMode;
import ru.afal.alfabattle.usecase.repository.AtmLocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlfaAtmLocationService implements AtmLocationService {

    private final AtmLocationRepository atmLocationRepository;

    @Override
    public @NotNull AtmLocation findAtmByID(int deviceID) {
        return atmLocationRepository.findAtmByID(deviceID).orElseThrow(AtmNotFoundException::new);
    }

    @Override
    public @NotNull AtmLocation findNearest(double latitude, double longitude, @NotNull PaymentMode paymentMode) {
        List<AtmLocation> atmLocationList = Collections.emptyList();

        switch(paymentMode) {
            case ENABLED:
                atmLocationList = atmLocationRepository.findAllByPaymentsEnabled(true);
                break;
            case DISABLED:
                atmLocationList = atmLocationRepository.findAllByPaymentsEnabled(false);
                break;
            case ANY:
                atmLocationList = atmLocationRepository.findAll();
                break;
        }

        return atmLocationList.stream()
            .filter(a -> a.getLatitude() != null && a.getLongitude() != null)
            .min(Comparator.comparingDouble(l -> getDistance(l.getLatitude(), latitude, l.getLongitude(), longitude)))
            .orElseThrow(() -> new AtmNotFoundException("No ATMs with payment mode " + paymentMode + " were found"));
    }

    // TODO: move

    private double getDistance(double leftLatitude, double rightLatitude, double leftLongitude, double rightLongitude) {
        return Math.sqrt(sqr(leftLatitude - rightLatitude) + sqr(leftLongitude - rightLongitude));
    }

    private double sqr(double d) {
        return d * d;
    }
}
