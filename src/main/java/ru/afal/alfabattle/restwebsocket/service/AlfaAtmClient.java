package ru.afal.alfabattle.restwebsocket.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.afal.alfabattle.restwebsocket.configuration.FeignConfiguration;
import ru.afal.alfabattle.restwebsocket.model.Ret;

/**
 * Feign client
 * @author Fal.
 */
@FeignClient(name = "feignClient", url = "${feign.service.url}", configuration = FeignConfiguration.class)
public interface AlfaAtmClient {
  /**
   * Do something.
   * @return something.
   */
  @RequestMapping(method = RequestMethod.GET, value = "/atms")
  Ret getAtms();
}
