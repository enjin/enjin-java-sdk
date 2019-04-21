package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public class SendTokenData {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("token_index")
    private String tokenIndex;

    @SerializedName("recipient_address")
    private String recipientAddress;

    @SerializedName("recipient_identity_id")
    private BigInteger recipientIdentityId;

    private Integer value;

}
