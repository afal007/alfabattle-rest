package ru.afal.alfabattle.restwebsocket.controller.atm.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.usecase.AtmLocationService;
import ru.afal.alfabattle.usecase.model.PaymentMode;

import lombok.RequiredArgsConstructor;

@RestController("/atm/v1")
@RequiredArgsConstructor
public class AtmController {

    private final AtmLocationService atmLocationService;

    @GetMapping("/{deviceID}")
    public AtmLocation getAtmLocation(@PathVariable("deviceID") Integer deviceID) {
        return atmLocationService.findAtmByID(deviceID);
    }

    @GetMapping("/nearest")
    public AtmLocation getAtmLocation(
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @RequestParam(value = "payments", required = false) Boolean paymentsEnabled
    ) {
        return atmLocationService.findNearest(latitude, longitude, PaymentMode.from(paymentsEnabled));
    }
}
