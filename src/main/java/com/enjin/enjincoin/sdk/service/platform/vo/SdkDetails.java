package com.enjin.enjincoin.sdk.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Sdk Details class.
 * </p>
 */
public class SdkDetails {

    @SerializedName("driver")
    private String driver;

    @SerializedName("key")
    private String key;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("options")
    private SdkOptions options;

    public SdkDetails(final String driver, final String key, final String appId, final SdkOptions options) {
        super();
        this.driver = driver;
        this.key = key;
        this.appId = appId;
        this.options = options;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return this.driver;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return this.appId;
    }

    /**
     * @return the options
     */
    public SdkOptions getOptions() {
        return this.options;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SdkDetails [driver=" + this.driver + ", key=" + this.key + ", appId=" + this.appId + ", options=" + this.options + "]";
    }
}
