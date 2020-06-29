package ru.afal.alfabattle.usecase.mapper;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import ru.afal.alfabank.atmapi.model.ATMDetails;
import ru.afal.alfabank.atmapi.model.ATMServices;
import ru.afal.alfabank.atmapi.model.Coordinates;
import ru.afal.alfabank.atmapi.model.PostAddress;
import ru.afal.alfabattle.api.AtmLocation;

@Component
public class AlfaAtmMapper implements AtmMapper {

    @Override
    public @NotNull AtmLocation map(@NotNull ATMDetails atmDetails) {
        AtmLocation atmLocation = new AtmLocation();

        PostAddress address = atmDetails.getAddress();
        if(address != null) {
            atmLocation.setCity(address.getCity());
            atmLocation.setLocation(address.getLocation());
        }

        Coordinates coordinates = atmDetails.getCoordinates();
        if(coordinates != null) {
            String latitude = coordinates.getLatitude();
            if(latitude != null) {
                atmLocation.setLatitude(Double.valueOf(latitude));
            }
            String longitude = coordinates.getLongitude();
            if(longitude != null) {
                atmLocation.setLongitude(Double.valueOf(longitude));
            }
        }

        ATMServices services = atmDetails.getServices();
        if(services != null) {
            atmLocation.setPaymentsEnabled("Y".equals(services.getPayments()));
        }

        atmLocation.setDeviceId(atmDetails.getDeviceId());

        return atmLocation;
    }
}
