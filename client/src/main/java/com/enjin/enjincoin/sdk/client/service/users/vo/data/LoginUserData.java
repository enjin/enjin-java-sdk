package com.enjin.enjincoin.sdk.client.service.users.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class LoginUserData {

    @SerializedName("EnjinOauth")
    private JsonObject auth;

    public JsonObject getAuth() {
        return this.auth;
    }
}
