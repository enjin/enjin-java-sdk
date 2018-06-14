package com.enjin.enjincoin.sdk.client.service.users.vo.data;

import com.enjin.enjincoin.sdk.client.service.users.vo.User;
import com.google.gson.annotations.SerializedName;

public class LoginUserData {

    @SerializedName("EnjinOauth")
    private User auth;

    public User getAuth() {
        return this.auth;
    }
}
