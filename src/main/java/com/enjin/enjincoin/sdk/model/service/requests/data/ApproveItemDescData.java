package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class ApproveItemDescData {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("token_index")
    private String tokenIndex;

    @SerializedName("current_value")
    private Integer currentValue;

    private Integer value;

}
