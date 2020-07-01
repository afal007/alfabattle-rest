package ru.afal.alfabattle.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value(staticConstructor = "withStatus")
@ApiModel(description = "Generic error")
public class Error {
    @ApiModelProperty(value = "Short description", example = "ATM was not found")
    String status;
}
