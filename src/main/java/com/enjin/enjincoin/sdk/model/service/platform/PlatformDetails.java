package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

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
