package com.enjin.enjincoin.sdk.model.service.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class AuthResult {

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("access_token")
    private String accessToken;

}
