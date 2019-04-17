package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    private Integer id;

    private String name;

    private String email;

    @SerializedName("access_tokens")
    private List<JsonElement> accessTokens;

    private List<Role> roles;

    private List<Identity> identities;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public List<JsonElement> getAccessTokens() {
        return this.accessTokens;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public List<Identity> getIdentities() {
        return this.identities;
    }

}
