package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Role {

    private Integer id;

    private String name;

    private List<Permission> permissions;

    @SerializedName("app_id")
    private Integer appId;

}
