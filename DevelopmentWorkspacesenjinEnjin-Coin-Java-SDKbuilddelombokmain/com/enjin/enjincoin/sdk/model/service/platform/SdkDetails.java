package com.enjin.enjincoin.sdk.model.service.platform;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Sdk Details class.
 * </p>
 */
public class SdkDetails {

    private String driver;

    private String key;

    private String secret;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("options")
    private SdkOptions options;

    public SdkDetails(final String driver,
                      final String key,
                      final String secret,
                      final String appId,
                      final SdkOptions options) {
        super();
        this.driver = driver;
        this.key = key;
        this.secret = secret;
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

    public String getSecret() {
        return secret;
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
