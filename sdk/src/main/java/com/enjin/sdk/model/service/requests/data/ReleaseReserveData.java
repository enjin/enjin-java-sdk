package com.enjin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class ReleaseReserveData {

    @SerializedName("token_id")
    private String tokenId;

    private Integer value;

}
