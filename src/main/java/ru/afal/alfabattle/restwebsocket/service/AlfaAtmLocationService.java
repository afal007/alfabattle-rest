package ru.afal.alfabattle.restwebsocket.service;

import java.util.Comparator;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import ru.afal.alfabank.atmapi.model.ATMDetails;
import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.dal.dao.AlfaAtmDAO;
import ru.afal.alfabattle.restwebsocket.exception.AtmNotFoundException;
import ru.afal.alfabattle.restwebsocket.model.PaymentMode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlfaAtmLocationService implements AtmLocationService {

    private final AlfaAtmDAO alfaAtmDAO;

    @Override
    public @NotNull AtmLocation findAtmByID(long deviceID) {
        return alfaAtmDAO.getAtmDetails()
            .getData()
            .getAtms()
            .stream()
            .filter(a -> Objects.equals(deviceID, a.getDeviceId()))
            .findFirst()
            .map(this::map)
            .orElseThrow(AtmNotFoundException::new);
    }

    @Override
    public @NotNull AtmLocation findNearest(double latitude, double longitude, @NotNull PaymentMode paymentMode) {
        return alfaAtmDAO.getAtmDetails()
            .getData()
            .getAtms()
            .stream()
            .sorted(Comparator.comparingDouble(l -> getDistance(Double.valueOf(l.getCoordinates().getLatitude()),
                latitude,
                Double.valueOf(l.getCoordinates().getLongitude()),
                longitude
            )))
            .filter(a -> paymentMode != PaymentMode.ENABLED ||
                a.getServices() != null && "Y".equals(a.getServices().getPayments()))
            .filter(a -> paymentMode != PaymentMode.DISABLED ||
                a.getServices() != null && "N".equals(a.getServices().getPayments()))
            .findFirst()
            .map(this::map)
            .orElseThrow(() -> new AtmNotFoundException("No ATMs with payment mode " + paymentMode + " were found"));
    }

    private double getDistance(double leftLatitude, double rightLatitude, double leftLongitude, double rightLongitude) {
        return Math.sqrt(sqr(leftLatitude - rightLatitude) + sqr(leftLongitude - rightLongitude));
    }

    private double sqr(double d) {
        return d * d;
    }

    private AtmLocation map(ATMDetails atm) {
        AtmLocation atmLocation = new AtmLocation();
        atmLocation.setCity(atm.getAddress().getCity());
        atmLocation.setDeviceId((long) atm.getDeviceId());
        atmLocation.setLatitude(Double.valueOf(atm.getCoordinates().getLatitude()));
        atmLocation.setLongitude(Double.valueOf(atm.getCoordinates().getLongitude()));
        atmLocation.setLocation(atm.getAddress().getLocation());
        atmLocation.setPayments("Y".equals(atm.getServices().getPayments()));
        return atmLocation;
    }
}
