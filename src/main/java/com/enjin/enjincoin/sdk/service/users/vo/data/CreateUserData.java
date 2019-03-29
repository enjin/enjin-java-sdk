package com.enjin.enjincoin.sdk.service.users.vo.data;

import com.enjin.enjincoin.sdk.service.users.vo.User;
import com.google.gson.annotations.SerializedName;

public class CreateUserData {

    @SerializedName("CreateUser")
    private User user;

    public User getUser() {
        return this.user;
    }
}
