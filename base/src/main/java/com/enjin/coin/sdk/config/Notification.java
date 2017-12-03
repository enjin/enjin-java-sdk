package com.enjin.coin.sdk.config;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.enjin.coin.sdk.util.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public class Notification {

    /**
     * The appId to use.
     * @return String
     */
    @Value.Default
    @SerializedName("id")
    public String getAppId() {
        return "";
    }

    /**
     * The appKey to use.
     * @return String
     */
    @Value.Default
    @SerializedName("key")
    public String getAppKey() {
        return "";
    }

    /**
     * The appSecret to use.
     * @return String
     */
    @Value.Default
    @SerializedName("secret")
    public String getAppSecret() {
        return "";
    }

    /**
     * The cluster to use.
     * @return String
     */
    @Value.Default
    @SerializedName("cluster")
    public String getCluster() {
        return "";
    }

    /**
     * The appChannel to use.
     * @return String
     */
    @Value.Default
    @SerializedName("channel")
    public String getAppChannel() {
        return "";
    }

    /**
     * The activityTimeout to use.
     * @return long
     */
    @Value.Default
    @SerializedName("activity-timeout")
    public Long getActivityTimeout() {
        return Constants.FOUR_THOUSAND;
    }
}
