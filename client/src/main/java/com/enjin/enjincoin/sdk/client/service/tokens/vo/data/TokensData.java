package com.enjin.enjincoin.sdk.client.service.tokens.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TokensData {

    @SerializedName("EnjinTokens")
    private List<JsonObject> tokens;

    public List<JsonObject> getTokens() {
        return this.tokens;
    }
}
