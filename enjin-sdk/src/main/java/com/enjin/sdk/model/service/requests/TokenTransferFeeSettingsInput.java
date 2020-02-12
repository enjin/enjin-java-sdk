package com.enjin.sdk.model.service.requests;

import com.enjin.sdk.model.service.tokens.TokenTransferFeeType;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class TokenTransferFeeSettingsInput {

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
