package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTokensResult {

    @SerializedName("EnjinTokens")
    private List<Token> tokens;

    public List<Token> getTokens() {
        return this.tokens;
    }

    public boolean isEmpty() {
        return this.tokens == null || this.tokens.isEmpty();
    }
}
