package ru.afal.alfabattle.api;

import lombok.Data;

@Data
public class AtmLocation {
  private Long deviceId;
  private Double latitude;
  private Double longitude;
  private String city;
  private String location;
  private boolean payments;
}
