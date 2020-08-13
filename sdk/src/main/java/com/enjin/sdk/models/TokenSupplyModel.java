package com.enjin.sdk.models;

/**
 * The token supply model used.
 *
 * @author Evan Lindsay
 * @see Token
 */
public enum TokenSupplyModel {

    FIXED,
    SETTABLE,
    INFINITE,
    COLLAPSING,
    ANNUAL_VALUE,
    ANNUAL_PERCENTAGE,

}
