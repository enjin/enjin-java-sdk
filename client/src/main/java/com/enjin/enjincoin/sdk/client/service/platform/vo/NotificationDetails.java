package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Notification Details class
 * </p>
 */
public class NotificationDetails {

    @SerializedName("sdk")
    private SdkDetails sdkDetails;

    @SerializedName("mobile")
    private MobileDetails mobileDetails;


    /**
     * Class constructor.
     * @param sdkDetails
     * @param mobileDetails
     */
    public NotificationDetails(SdkDetails sdkDetails, MobileDetails mobileDetails) {
        super();
        this.sdkDetails = sdkDetails;
        this.mobileDetails = mobileDetails;
    }

    /**
     * @return the sdkDetails
     */
    public SdkDetails getSdkDetails() {
        return sdkDetails;
    }

    /**
     * @return the mobileDetails
     */
    public MobileDetails getMobileDetails() {
        return mobileDetails;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NotificationsDetails [sdkDetails=" + sdkDetails + ", mobileDetails=" + mobileDetails + "]";
    }


}
