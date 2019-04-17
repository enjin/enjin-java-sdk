package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class SetWhitelistedData {

    @SerializedName("token_id")
    private String tokenId;

    private String account;

    private String whitelisted;

    private Boolean on;

}
