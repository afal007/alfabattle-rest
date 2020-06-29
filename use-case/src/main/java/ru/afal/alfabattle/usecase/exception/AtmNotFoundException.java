package ru.afal.alfabattle.usecase.exception;

import java.util.Optional;

public class AtmNotFoundException extends RuntimeException {

    public AtmNotFoundException() {
    }

    public AtmNotFoundException(String message) {
        super(message);
    }

    public Optional<String> getOptionalMessage() {
        return Optional.ofNullable(getMessage());
    }
}
