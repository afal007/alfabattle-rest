package ru.afal.alfabattle.restwebsocket.service;

import org.jetbrains.annotations.NotNull;
import ru.afal.alfabattle.api.AtmLocation;

import java.util.Optional;

/**
 * Tmp service
 * @author Fal.
 */
public interface AtmService {
  /**
   * Do shit.
   * @return shit.
   * @param deviceID
   */
  @NotNull
  Optional<AtmLocation> findAtm(Long deviceID);

  AtmLocation findNearest(Double latitude, Double longitude, Boolean payments);
}
