package com.enjin.enjincoin.sdk.service.platform.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <p>
 * Platform Config used throughout the sdk.
 * </p>
 */
public class PlatformDetails {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("notifications")
    private NotificationDetails notificationDetails;

    private List<AppDetail> apps;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public NotificationDetails getNotificationDetails() {
        return this.notificationDetails;
    }

    public List<AppDetail> getApps() {
        return this.apps;
    }
}
