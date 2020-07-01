package ru.afal.alfabattle.api.atm;

import lombok.Data;

@Data
public class AtmLocation {
    private String city;
    private String location;
    private Double latitude;
    private Double longitude;
    private Integer deviceId;
    private boolean paymentsEnabled;
}
