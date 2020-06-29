package ru.afal.alfabattle.usecase.model;

/**
 * ATM payment mode.
 *
 * @author Fal.
 */
public enum PaymentMode {
    /**
     * Payments are enabled.
     */
    ENABLED,

    /**
     * Payments are disabled.
     */
    DISABLED,

    /**
     * Any mode.
     */
    ANY;

    public static PaymentMode from(Boolean paymentsEnabled) {
        if(paymentsEnabled == null) {
            return ANY;
        } else if(paymentsEnabled) {
            return ENABLED;
        } else {
            return DISABLED;
        }
    }
}
