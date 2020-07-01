package ru.afal.alfabattle.rest.atm.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.afal.alfabattle.api.atm.AtmLocation;
import ru.afal.alfabattle.interactor.atm.AtmLocationInteractor;
import ru.afal.alfabattle.interactor.gateway.atm.PaymentMode;

import lombok.RequiredArgsConstructor;

@RestController("/atm/v1")
@RequiredArgsConstructor
public class AtmController {

    private final AtmLocationInteractor atmLocationInteractor;

    @GetMapping("/{deviceID}")
    public AtmLocation getAtmLocation(@PathVariable("deviceID") Integer deviceID) {
        return atmLocationInteractor.findAtmByID(deviceID);
    }

    @GetMapping("/nearest")
    public AtmLocation getAtmLocation(
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @RequestParam(value = "payments", required = false) Boolean paymentsEnabled
    ) {
        return atmLocationInteractor.findNearest(latitude, longitude, PaymentMode.from(paymentsEnabled));
    }
}
