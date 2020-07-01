package ru.afal.alfabattle.dal.atm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.afal.alfabank.atmapi.atm.JSONResponseBankATMDetails;

/**
 * Alfabank ATM service client.
 *
 * @author Fal.
 */
@FeignClient(name = "atmClient", url = "${atm.service.url}", configuration = AtmFeignConfiguration.class)
public interface AlfaAtmDAO {
    /**
     * Get information about all ATMs.
     *
     * @return information about all ATMs.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/atms")
    JSONResponseBankATMDetails getAtmDetails();
}
