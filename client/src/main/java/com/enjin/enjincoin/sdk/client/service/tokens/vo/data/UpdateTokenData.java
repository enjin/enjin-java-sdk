package com.enjin.enjincoin.sdk.client.service.tokens.vo.data;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.google.gson.annotations.SerializedName;

public class UpdateTokenData {

    @SerializedName("UpdateEnjinToken")
    private Token token;

    public Token getToken() {
        return this.token;
    }
}
