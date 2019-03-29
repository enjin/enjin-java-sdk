package com.enjin.enjincoin.sdk.service.tokens.vo;

import com.google.gson.annotations.SerializedName;

public class TokenTransferFeeSettings {

    private TokenTransferFeeType type;

    @SerializedName("token_id")
    private String tokenId;

    private Integer value;

    public TokenTransferFeeType getType() {
        return this.type;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public Integer getValue() {
        return this.value;
    }
}
