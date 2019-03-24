package com.enjin.enjincoin.sdk.client.service.users.vo.data;

import com.enjin.enjincoin.sdk.client.service.users.vo.User;
import com.google.gson.annotations.SerializedName;

public class CreateUserData {

    @SerializedName("CreateUser")
    private User user;

    public User getUser() {
        return this.user;
    }
}
