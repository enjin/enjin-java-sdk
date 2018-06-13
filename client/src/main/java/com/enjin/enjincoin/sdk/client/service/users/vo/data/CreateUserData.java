package com.enjin.enjincoin.sdk.client.service.users.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CreateUserData {

    @SerializedName("CreateUser")
    private JsonObject user;

    public JsonObject getUser() {
        return this.user;
    }
}
