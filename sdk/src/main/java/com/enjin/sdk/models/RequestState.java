package com.enjin.sdk.models;

/**
 * Represents the state of a transaction.
 *
 * @see Request
 */
public enum RequestState {

    PENDING,
    BROADCAST,
    TP_PROCESSING,
    EXECUTED,
    CANCELED_USER,
    CANCELED_PLATFORM,
    DROPPED,
    FAILED,

}
