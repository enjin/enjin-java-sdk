package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUsersResult {

    @SerializedName("EnjinUsers")
    private List<User> users;

    public List<User> getUsers() {
        return this.users;
    }

    public boolean isEmpty() {
        return this.users == null || this.users.isEmpty();
    }
}
