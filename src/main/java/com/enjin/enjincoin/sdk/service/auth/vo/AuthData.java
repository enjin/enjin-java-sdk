package com.enjin.enjincoin.sdk.service.auth.vo;

import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("access_token")
    private String accessToken;

    public AuthData() {
        super();
    }

    public AuthData(String tokenType, Long expiresIn, String accessToken) {
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
