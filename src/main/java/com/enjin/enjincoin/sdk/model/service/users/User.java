package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.math.BigInteger;
import java.util.List;

@Getter
public class User {

    private BigInteger id;

    private String name;

    private String email;

    @SerializedName("access_tokens")
    private List<JsonElement> accessTokens;

    private List<Role> roles;

    private List<Identity> identities;

}
