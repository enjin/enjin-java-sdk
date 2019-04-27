package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a get platform request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.platform.PlatformService
 * @see PlatformDetails
 */
@Getter
public class GetPlatformResult {

    /**
     * The platform details.
     *
     * @return the platform details.
     */
    @SerializedName("EnjinPlatform")
    private PlatformDetails platform;

}
