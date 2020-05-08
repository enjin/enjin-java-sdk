package com.enjin.sdk.models.request;

import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.TokenTransferFeeType;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

/**
 * The transfer fee settings for a token.
 *
 * @see Token
 * @see TokenTransferFeeType
 */
@Builder
public class TokenTransferFeeSettingsInput {

    /**
     * The transfer fee strategy type.
     *
     * @param type the transfer fee type.
     * @return     the builder.
     */
    private TokenTransferFeeType type;

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return        the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The fee value.
     *
     * @param value the fee value.
     * @return      the builder.
     */
    private String value;
}
