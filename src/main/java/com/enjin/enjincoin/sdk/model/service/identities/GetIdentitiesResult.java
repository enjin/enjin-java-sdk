package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class GetIdentitiesResult {

    @SerializedName("EnjinIdentities")
    private List<Identity> identities;

}
