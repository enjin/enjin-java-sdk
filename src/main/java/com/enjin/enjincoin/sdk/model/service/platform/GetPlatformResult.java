package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class GetPlatformResult {

    @SerializedName("EnjinPlatform")
    private PlatformDetails platform;

}
