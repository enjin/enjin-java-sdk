package com.enjin.sdk.models.request;

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
    CANCELED_USER,
    CANCELED_PLATFORM,
    DROPPED,
    FAILED

}
