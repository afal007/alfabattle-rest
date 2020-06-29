package ru.afal.alfabattle.usecase.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import ru.afal.alfabank.atmapi.model.ATMDetails;
import ru.afal.alfabank.atmapi.model.BankATMDetails;
import ru.afal.alfabank.atmapi.model.Error;
import ru.afal.alfabank.atmapi.model.JSONResponseBankATMDetails;
import ru.afal.alfabattle.api.AtmLocation;
import ru.afal.alfabattle.dal.dao.AlfaAtmDAO;
import ru.afal.alfabattle.usecase.exception.AtmSearchException;
import ru.afal.alfabattle.usecase.mapper.AtmMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AlfaAtmLocationRepository implements AtmLocationRepository {

    private final AtmMapper atmMapper;
    private final AlfaAtmDAO alfaAtmDAO;

    // TODO caching

    @Override
    public @NotNull Optional<AtmLocation> findAtmByID(int deviceID) {
        return getAtmDetailsList().stream()
            .filter(atm -> atm.getDeviceId() != null)
            .filter(atm -> deviceID == atm.getDeviceId())
            .findFirst()
            .map(atmMapper::map);
    }

    @Override
    public @NotNull List<AtmLocation> findAll() {
        return getAtmDetailsList().stream().map(atmMapper::map).collect(Collectors.toList());
    }

    @Override
    public @NotNull List<AtmLocation> findAllByPaymentsEnabled(boolean enabled) {
        return getAtmDetailsList().stream()
            .map(atmMapper::map)
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
