package com.enjin.enjincoin.sdk.client.service.tokens.vo.data;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.google.gson.annotations.SerializedName;

public class CreateTokenData {

    @SerializedName("CreateEnjinToken")
    private Token token;

    public Token getToken() {
        return this.token;
    }
}
