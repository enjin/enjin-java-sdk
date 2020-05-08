package com.enjin.sdk.models.token;

import lombok.Getter;
import lombok.ToString;

/**
 * Defines the fee structure for a token.
 *
 * @author Evan Lindsay
 * @see Token
 * @see TokenTransferFeeType
 */
@ToString
@Getter
public class TokenTransferFeeSettings {

    /**
     * -- GETTER --
     * Returns the transfer fee strategy type.
     *
     * @return the strategy type.
     */
    private TokenTransferFeeType type;

    /**
     * -- GETTER --
     * Returns the token id.
     *
     * @return the token id.
     */
    private String tokenId;

    /**
     * -- GETTER --
     * Returns the fee value.
     *
     * @return the fee value.
     */
    private String value;

}
