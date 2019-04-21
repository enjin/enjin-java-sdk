package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * Sdk Details class.
 * </p>
 */
@ToString
@Getter
public class SdkDetails {

    private String driver;

    private String key;

    private String secret;

    @SerializedName("app_id")
    private String appId;

    private SdkOptions options;

}
