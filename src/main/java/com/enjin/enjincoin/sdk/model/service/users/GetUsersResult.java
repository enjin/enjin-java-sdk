package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class GetUsersResult {

    @SerializedName("EnjinUsers")
    private List<User> users;

}
