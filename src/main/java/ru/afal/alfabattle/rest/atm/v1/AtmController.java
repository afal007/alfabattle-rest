package ru.afal.alfabattle.rest.atm.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.afal.alfabattle.api.Error;
import ru.afal.alfabattle.api.atm.AtmLocation;
import ru.afal.alfabattle.interactor.atm.AtmLocationInteractor;
import ru.afal.alfabattle.interactor.gateway.atm.PaymentMode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "Operations with ATMs")
@RestController
@RequestMapping(value = "/atm/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AtmController {

    private final AtmLocationInteractor atmLocationInteractor;

    @ApiOperation(value = "Get ATM location by device ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
    })
    @GetMapping("/{deviceID}")
    public AtmLocation getAtmLocation(@ApiParam(value = "ATM identifier", required = true, example = "153463") @PathVariable("deviceID") int deviceID) {
        return atmLocationInteractor.findAtmByID(deviceID);
    }

    @ApiOperation("Get nearest ATM location by longitude and latitude with possible filtration by availability of payments")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class)
    })
    @GetMapping("/nearest")
    public AtmLocation getAtmLocation(
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @ApiParam("Filter according to payments availability. Null if doesn't matter.") @RequestParam(value = "payments", required = false) Boolean paymentsEnabled
    ) {
        return atmLocationInteractor.findNearest(latitude, longitude, PaymentMode.from(paymentsEnabled));
    }
}
