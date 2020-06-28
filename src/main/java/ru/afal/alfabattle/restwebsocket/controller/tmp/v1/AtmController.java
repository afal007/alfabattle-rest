package ru.afal.alfabattle.restwebsocket.controller.tmp.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.restwebsocket.exception.AtmNotFoundException;
import ru.afal.alfabattle.restwebsocket.service.AtmService;

@RestController("/")
@RequiredArgsConstructor
public class AtmController {

  private final AtmService atmService;

  @GetMapping("/atms/{deviceID}")
  public AtmLocation getAtmLocation(@PathVariable("deviceID") Long deviceID) {
    return atmService.findAtm(deviceID).orElseThrow(AtmNotFoundException::new);
  }

  @GetMapping("/atms/nearest")
  public ResponseEntity<AtmLocation> getAtmLocation(
    @RequestParam("latitude") double latitude,
    @RequestParam("longitude") double longitude,
    @RequestParam(value = "payments", required = false) Boolean payments
  ) {
    return ResponseEntity.ok(atmService.findNearest(latitude, longitude, payments));
  }
}
