package com.enjin.enjincoin.sdk.model.service.auth;

import com.google.gson.annotations.SerializedName;

public class AuthResult {

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("access_token")
    private String accessToken;

    public AuthResult() {
        super();
    }

    public AuthResult(String tokenType, Long expiresIn, String accessToken) {
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
