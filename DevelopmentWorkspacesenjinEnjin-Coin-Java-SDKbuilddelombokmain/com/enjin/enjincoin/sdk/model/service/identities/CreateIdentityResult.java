package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;

public class CreateIdentityResult {

    @SerializedName("CreateEnjinIdentity")
    private Identity identity;

    public Identity getIdentity() {
        return this.identity;
    }
}
