package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class LoginUserResult {

    @SerializedName("EnjinOauth")
    private User user;

}
