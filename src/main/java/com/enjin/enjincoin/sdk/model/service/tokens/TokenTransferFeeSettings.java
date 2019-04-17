package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;

public class TokenTransferFeeSettings {

    private TokenTransferFeeType type;

    @SerializedName("token_id")
    private String tokenId;

    private String value;

    /*
    ----- Methods -----
     */

    public TokenTransferFeeType getType() {
        return this.type;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public String getValue() {
        return this.value;
    }
}
