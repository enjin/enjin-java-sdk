package com.enjin.enjincoin.sdk.client.service.users.vo;

import com.enjin.enjincoin.sdk.client.service.identities.vo.Identity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    private Integer id;

    private String name;

    private String email;

    @SerializedName("created_at")
    private JsonObject createdAt;

    @SerializedName("updated_at")
    private JsonObject updatedAt;

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

    public JsonObject getCreatedAt() {
        return this.createdAt;
    }

    public JsonObject getUpdatedAt() {
        return this.updatedAt;
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
