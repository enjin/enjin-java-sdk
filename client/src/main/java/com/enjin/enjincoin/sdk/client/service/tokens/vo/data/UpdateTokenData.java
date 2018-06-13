package com.enjin.enjincoin.sdk.client.service.tokens.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class UpdateTokenData {

    @SerializedName("UpdateEnjinToken")
    private JsonObject token;

    public JsonObject getToken() {
        return this.token;
    }
}
