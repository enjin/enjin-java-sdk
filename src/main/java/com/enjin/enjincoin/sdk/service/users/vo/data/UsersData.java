package com.enjin.enjincoin.sdk.service.users.vo.data;

import com.enjin.enjincoin.sdk.service.users.vo.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersData {

    @SerializedName("EnjinUsers")
    private List<User> users;

    public List<User> getUsers() {
        return this.users;
    }

    public boolean isEmpty() {
        return this.users == null || this.users.isEmpty();
    }
}
