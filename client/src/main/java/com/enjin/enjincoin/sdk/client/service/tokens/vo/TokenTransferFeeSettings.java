package com.enjin.enjincoin.sdk.client.service.tokens.vo;

import com.google.gson.annotations.SerializedName;

public class TokenTransferFeeSettings {

    private String type;

    @SerializedName("token_id")
    private String tokenId;

    private Integer value;

    public String getType() {
        return this.type;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public Integer getValue() {
        return this.value;
    }
}
