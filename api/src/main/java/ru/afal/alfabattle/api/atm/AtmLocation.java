package ru.afal.alfabattle.api.atm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "ATM location")
public class AtmLocation {
    @ApiModelProperty(value = "City in which ATM is located", example = "Москва")
    private String city;
    @ApiModelProperty(value = "Detailed address description", example = "Старокаширское ш., 4, корп. 10")
    private String location;
    @ApiModelProperty(value = "Latitude", example = "55.6610213")
    private Double latitude;
    @ApiModelProperty(value = "Longitude", example = "37.6309405")
    private Double longitude;
    @ApiModelProperty(value = "ATM identifier", example = "153463")
    private Integer deviceId;
    @ApiModelProperty(value = "Availability of payments", example = "false")
    private boolean paymentsEnabled;
}
