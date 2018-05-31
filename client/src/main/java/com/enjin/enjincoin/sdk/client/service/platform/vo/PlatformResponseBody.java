package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * <p>
 * Platform Config used throughout the sdk.
 * </p>
 */
public class PlatformResponseBody {

    @SerializedName("platform")
    private PlatformDetails platformDetails;

    @SerializedName("notifications")
    private NotificationDetails notificationDetails;

    @SerializedName("apps")
    private AppDetail[] appDetails;

    public PlatformResponseBody(final PlatformDetails platformDetails,
                                final NotificationDetails notificationDetails,
                                final AppDetail[] appDetails) {
        super();
        this.platformDetails = platformDetails;
        this.notificationDetails = notificationDetails;
        this.appDetails = appDetails;
    }

    /**
     * @return the platformDetails
     */
    public PlatformDetails getPlatformDetails() {
        return this.platformDetails;
    }

    /**
     * @return the notificationDetails
     */
    public NotificationDetails getNotificationDetails() {
        return this.notificationDetails;
    }

    /**
     * @return the appDetails
     */
    public AppDetail[] getAppDetails() {
        return this.appDetails;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlatformResponseBody [platformDetails=" + this.platformDetails
                + ", notificationDetails=" + this.notificationDetails
                + ", appDetails=" + Arrays.toString(this.appDetails) + "]";
    }


}
