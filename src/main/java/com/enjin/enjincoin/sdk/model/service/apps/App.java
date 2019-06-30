package com.enjin.enjincoin.sdk.model.service.apps;

import com.enjin.enjincoin.sdk.model.service.users.User;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class App {

    private int id;

    private String secret;

    private String name;

    private String description;

    private String image;

    private User owner;

    @SerializedName("token_count")
    private int tokenCount;

}
