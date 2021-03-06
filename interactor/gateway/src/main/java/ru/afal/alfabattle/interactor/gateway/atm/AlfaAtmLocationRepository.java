package ru.afal.alfabattle.interactor.gateway.atm;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import ru.afal.alfabank.atmapi.atm.ATMDetails;
import ru.afal.alfabank.atmapi.atm.BankATMDetails;
import ru.afal.alfabank.atmapi.atm.Error;
import ru.afal.alfabank.atmapi.atm.JSONResponseBankATMDetails;
import ru.afal.alfabattle.api.atm.AtmLocation;
import ru.afal.alfabattle.dal.atm.AlfaAtmDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AlfaAtmLocationRepository implements AtmLocationRepository {

    private final AtmMapper atmMapper;
    private final AlfaAtmDAO alfaAtmDAO;
    private final AtmLocationRepository atmLocationRepository;

    public AlfaAtmLocationRepository(
        AtmMapper atmMapper, AlfaAtmDAO alfaAtmDAO, @Lazy AtmLocationRepository atmLocationRepository
    ) {
        this.atmMapper = atmMapper;
        this.alfaAtmDAO = alfaAtmDAO;
        this.atmLocationRepository = atmLocationRepository;
    }

    @Override
    public @NotNull Optional<AtmLocation> findAtmByID(int deviceID) {
        return atmLocationRepository.findAll()
            .stream()
            .filter(atm -> atm.getDeviceId() != null)
            .filter(atm -> deviceID == atm.getDeviceId())
            .findFirst();
    }

    // TODO: Move Cacheable to alfaAtmDAO?
    @Override
    @Cacheable(value = "atmLocationListCache", key = "#root.methodName")
    public @NotNull List<AtmLocation> findAll() {
        return getAtmDetailsList().stream().map(atmMapper::map).collect(Collectors.toList());
    }

    @Override
    public @NotNull List<AtmLocation> findAllByPaymentsEnabled(boolean enabled) {
        return atmLocationRepository.findAll()
            .stream()
            .filter(a -> a.isPaymentsEnabled() == enabled)
            .collect(Collectors.toList());
    }

    private List<ATMDetails> getAtmDetailsList() {
        JSONResponseBankATMDetails atmDetails = alfaAtmDAO.getAtmDetails();
        if(atmDetails.getSuccess() != null && !atmDetails.getSuccess()) {
            Error error = atmDetails.getError();
            if(error != null) {
                throw new AtmSearchException(error.getCode(), error.getMessage());
            } else {
                throw new AtmSearchException();
            }
        }

        List<ATMDetails> atmDetailsList = Collections.emptyList();
        BankATMDetails data = atmDetails.getData();
        if(data != null) {
            atmDetailsList = data.getAtms();
        }

        return atmDetailsList;
    }
}
