package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Role {

    private Integer id;

    private String name;

    private List<Permission> permissions;

    @SerializedName("app_id")
    private Integer appId;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public Integer getAppId() {
        return this.appId;
    }
}
