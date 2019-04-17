package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetIdentitiesResult {

    @SerializedName("EnjinIdentities")
    private List<Identity> identities;

    public List<Identity> getIdentities() {
        return this.identities;
    }

    public boolean isEmpty() {
        return this.identities == null || this.identities.isEmpty();
    }
}
