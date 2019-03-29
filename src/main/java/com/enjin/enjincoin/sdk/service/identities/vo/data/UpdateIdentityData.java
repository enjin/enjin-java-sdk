package com.enjin.enjincoin.sdk.service.identities.vo.data;

import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.google.gson.annotations.SerializedName;

public class UpdateIdentityData {

    @SerializedName("UpdateEnjinIdentity")
    private Identity identity;

    public Identity getIdentity() {
        return this.identity;
    }
}
