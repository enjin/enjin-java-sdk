package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;

public class CreateUserResult {

    @SerializedName("CreateUser")
    private User user;

    public User getUser() {
        return this.user;
    }
}
