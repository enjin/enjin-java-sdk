package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;

public class CreateTokenResult {

    @SerializedName("CreateEnjinToken")
    private Token token;

    public Token getToken() {
        return this.token;
    }
}
