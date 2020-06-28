package ru.afal.alfabattle.restwebsocket.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.restwebsocket.model.Atm;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlfaAtmService implements AtmService {

  private final AlfaAtmClient alfaAtmClient;

  @NotNull
  @Override
  public Optional<AtmLocation> findAtm(Long deviceID) {
    return alfaAtmClient.getAtms()
      .getData()
      .getAtms()
      .stream()
      .filter(a -> deviceID.equals(a.getDeviceId())).findFirst().map(this::map);
  }

  @Override
  public AtmLocation findNearest(Double latitude, Double longitude, Boolean payments) {
    List<Atm> atms = alfaAtmClient.getAtms().getData().getAtms();

    double minDist = Double.MAX_VALUE;
    Atm nearest = atms.get(0);
    for (Atm atm : atms) {
      double latitude1 = atm.getCoordinates().getLatitude();
      double longitude1 = atm.getCoordinates().getLongitude();
      double distance = Math.sqrt((latitude - latitude1) * (latitude - latitude1) + (longitude - longitude1) * (longitude - longitude1));

      if(distance < minDist) {
        if (payments != null && payments && !"Y".equals(atm.getServices().getPayments())) {
          continue;
        }

        minDist = distance;
        nearest = atm;
      }
    }

    return map(nearest);
  }

  private AtmLocation map(Atm atm) {
    AtmLocation atmLocation = new AtmLocation();
    atmLocation.setCity(atm.getAddress().getCity());
    atmLocation.setDeviceId(atm.getDeviceId());
    atmLocation.setLatitude(atm.getCoordinates().getLatitude());
    atmLocation.setLongitude(atm.getCoordinates().getLongitude());
    atmLocation.setLocation(atm.getAddress().getLocation());
    atmLocation.setPayments("Y".equals(atm.getServices().getPayments()));
    return atmLocation;
  }
}
