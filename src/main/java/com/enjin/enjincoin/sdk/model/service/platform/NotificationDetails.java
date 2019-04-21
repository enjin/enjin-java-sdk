package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * Notification Details class.
 * </p>
 */
@ToString
@Getter
public class NotificationDetails {

    @SerializedName("sdk")
    private SdkDetails sdk;

    @SerializedName("mobile")
    private MobileDetails mobile;


}
