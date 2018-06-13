package com.enjin.enjincoin.sdk.client.service.identities.vo.data;

import com.enjin.enjincoin.sdk.client.service.identities.vo.Identity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IdentitiesData {

    @SerializedName("EnjinIdentities")
    private List<Identity> identities;

    public List<Identity> getIdentities() {
        return this.identities;
    }
}
