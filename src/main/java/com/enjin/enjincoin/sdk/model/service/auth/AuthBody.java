package com.enjin.enjincoin.sdk.model.service.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class AuthBody {

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("client_secret")
    private String clientSecret;

}
