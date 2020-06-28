package ru.afal.alfabattle.restwebsocket.model;

import lombok.Data;

@Data
public class Atm {
  private Long deviceId;
  private Address address;
  private Services services;
  private Coordinates coordinates;
}
