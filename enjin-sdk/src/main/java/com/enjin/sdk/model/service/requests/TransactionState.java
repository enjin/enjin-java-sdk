package com.enjin.sdk.model.service.requests;

/**
 * Represents the state of a request.
 *
 * @author Evan Lindsay
 * @see Transaction
 */
public enum TransactionState {

    PENDING,
    BROADCAST,
    TP_PROCESSING,
    EXECUTED,
    CONFIRMED,
    CANCELED_USER,
    CANCELED_PLATFORM,
    FAILED

}
