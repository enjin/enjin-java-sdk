package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.math.BigInteger;

/**
 * <p>
 * Platform Config used throughout the sdk.
 * </p>
 */
@Getter
public class PlatformDetails {

    private String name;

    private BigInteger id;

    private String network;

    @SerializedName("blockheight")
    private Integer blockHeight;

    private NotificationDetails notifications;

}
