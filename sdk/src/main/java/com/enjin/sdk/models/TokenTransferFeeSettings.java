package com.enjin.sdk.models;

import lombok.Getter;
import lombok.ToString;

/**
 * Models transfer fee settings for an item.
 *
 * @author Evan Lindsay
 * @see Token
 */
@ToString
@Getter
public class TokenTransferFeeSettings {

    /**
     * -- GETTER --
     * @return the transfer fee type
     */
    private TokenTransferFeeType type;

    /**
     * -- GETTER --
     * <br>
     * <p>
     *     Will either be the item ID or "0" for ENJ.
     * </p>
     *
     * @return the token (item) ID
     */
    private String tokenId;

    /**
     * -- GETTER --
     * @return the fee value in Wei
     */
    private String value;

}
