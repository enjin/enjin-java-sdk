package com.enjin.enjincoin.sdk.model.service.identities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class DeleteIdentityResult {

    @SerializedName("DeleteEnjinIdentity")
    private Identity identity;

}
