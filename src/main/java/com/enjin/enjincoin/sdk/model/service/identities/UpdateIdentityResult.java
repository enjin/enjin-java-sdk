package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class UpdateIdentityResult {

    @SerializedName("UpdateEnjinIdentity")
    private Identity identity;

}
