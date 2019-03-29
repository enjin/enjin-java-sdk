package com.enjin.enjincoin.sdk.service.platform.vo.data;

import com.enjin.enjincoin.sdk.service.platform.vo.PlatformDetails;
import com.google.gson.annotations.SerializedName;

public class PlatformData {

    @SerializedName("EnjinPlatform")
    private PlatformDetails platform;

    public PlatformDetails getPlatform() {
        return this.platform;
    }
}
