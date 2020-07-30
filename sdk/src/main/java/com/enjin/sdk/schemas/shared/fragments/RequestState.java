package com.enjin.sdk.schemas.shared.fragments;

/**
 * Represents the state of a request.
 *
 * @author Evan Lindsay
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
    FAILED

}
