package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferable;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class SetTransferableData {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("token_index")
    private String tokenIndex;

    private TokenTransferable transferable;

}
