package com.enjin.enjincoin.sdk.service.platform.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <p>
 * Platform Config used throughout the sdk.
 * </p>
 */
public class PlatformDetails {

    private String name;

    private String id;

    private String network;

    @SerializedName("notifications")
    private NotificationDetails notificationDetails;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getNetwork() {
        return network;
    }

    public NotificationDetails getNotificationDetails() {
        return this.notificationDetails;
    }
}
