package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Notification Details class.
 * </p>
 */
public class NotificationDetails {

    @SerializedName("sdk")
    private SdkDetails sdkDetails;

    @SerializedName("mobile")
    private MobileDetails mobileDetails;


    public NotificationDetails(final SdkDetails sdkDetails, final MobileDetails mobileDetails) {
        super();
        this.sdkDetails = sdkDetails;
        this.mobileDetails = mobileDetails;
    }

    /**
     * @return the sdkDetails
     */
    public SdkDetails getSdkDetails() {
        return this.sdkDetails;
    }

    /**
     * @return the mobileDetails
     */
    public MobileDetails getMobileDetails() {
        return this.mobileDetails;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NotificationsDetails [sdkDetails=" + this.sdkDetails + ", mobileDetails=" + this.mobileDetails + "]";
    }


}
