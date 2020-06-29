package ru.afal.alfabattle.usecase.exception;

public class AtmSearchException extends RuntimeException {

    private Integer code;

    public AtmSearchException() {
        super("Something went wrong during ATM search");
    }

    public AtmSearchException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public String getMessage() {
        if(code == null) {
            return super.getMessage();
        }

        return String.format("Error code %d. %s", code, super.getMessage());
    }
}
