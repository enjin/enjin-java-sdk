package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TokenTransferFeeSettings {

    private TokenTransferFeeType type;

    @SerializedName("token_id")
    private String tokenId;

    private String value;

}
