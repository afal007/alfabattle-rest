package ru.afal.alfabattle.rest.atm.v1;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ru.afal.alfabattle.api.Error;
import ru.afal.alfabattle.interactor.atm.AtmNotFoundException;

@RestControllerAdvice("ru.afal.alfabattle.rest.atm")
public class AtmControllerAdvice {

    private static final Error ATM_WAS_NOT_FOUND = Error.withStatus("Atm was not found");

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AtmNotFoundException.class)
    public ResponseEntity<Error> handleAtmNotFoundException(@NotNull AtmNotFoundException e) {
        Error error = e.getOptionalMessage().map(Error::withStatus).orElse(ATM_WAS_NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
