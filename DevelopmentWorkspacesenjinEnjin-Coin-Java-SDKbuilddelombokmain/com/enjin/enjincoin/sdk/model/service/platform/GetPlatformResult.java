package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

public class GetPlatformResult {

    @SerializedName("EnjinPlatform")
    private PlatformDetails platform;

    public PlatformDetails getPlatform() {
        return this.platform;
    }
}
