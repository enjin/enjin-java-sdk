package com.enjin.enjincoin.sdk.client.service.users.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersData {

    @SerializedName("EnjinUsers")
    private List<JsonObject> users;

    public List<JsonObject> getUsers() {
        return this.users;
    }
}
