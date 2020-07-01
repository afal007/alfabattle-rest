package ru.afal.alfabattle.interactor.gateway.atm;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import ru.afal.alfabank.atmapi.atm.ATMDetails;
import ru.afal.alfabank.atmapi.atm.ATMServices;
import ru.afal.alfabank.atmapi.atm.Coordinates;
import ru.afal.alfabank.atmapi.atm.PostAddress;
import ru.afal.alfabattle.api.atm.AtmLocation;

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
