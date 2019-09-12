package com.enjin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;

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
     * The transfer fee strategy type.
     *
     * @return the strategy type.
     */
    private TokenTransferFeeType type;

    /**
     * The token id.
     *
     * @return the token id.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The fee value.
     *
     * @return the fee value.
     */
    private String value;

}
