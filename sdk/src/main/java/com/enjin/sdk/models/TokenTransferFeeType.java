package com.enjin.sdk.models;

/**
 * Represents the transfer fee type.
 *
 * @author Evan Lindsay
 * @see TokenTransferFeeSettings
 */
public enum TokenTransferFeeType {

    NONE,
    PER_TRANSFER,
    PER_CRYPTO_ITEM,
    RATIO_CUT,
    RATIO_EXTRA,

}
