package com.enjin.enjincoin.sdk.service.auth.vo;

import com.google.gson.annotations.SerializedName;

public class AuthBody {

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("client_secret")
    private String clientSecret;

    public AuthBody(String grantType, String clientId, String clientSecret) {
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

}
