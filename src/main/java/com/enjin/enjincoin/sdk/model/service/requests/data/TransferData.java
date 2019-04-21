package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public class TransferData {

    private String from;

    @SerializedName("from_id")
    private BigInteger fromId;

    private String to;

    @SerializedName("to_id")
    private BigInteger toId;

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("token_index")
    private String tokenIndex;

    private String value;

}
