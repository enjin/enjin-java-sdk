package com.enjin.enjincoin.sdk.client.service.tokens.vo.data;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TokensData {

    @SerializedName("EnjinTokens")
    private List<Token> tokens;

    public List<Token> getTokens() {
        return this.tokens;
    }

    public boolean isEmpty() {
        return this.tokens == null || this.tokens.isEmpty();
    }
}
