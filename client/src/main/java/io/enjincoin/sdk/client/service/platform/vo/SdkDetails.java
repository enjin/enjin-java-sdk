package io.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Sdk Details class
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

    /**
     * Class constructor.
     * @param driver
     * @param key
     * @param appId
     * @param options
     */
    public SdkDetails(String driver, String key, String appId, SdkOptions options) {
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
        return driver;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @return the options
     */
    public SdkOptions getOptions() {
        return options;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SdkDetails [driver=" + driver + ", key=" + key + ", appId=" + appId + ", options=" + options + "]";
    }
}
