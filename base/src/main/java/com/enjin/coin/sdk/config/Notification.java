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
    @SerializedName("appId")
    public String getAppId() {
        return "replace-with-app-id";
    }

    /**
     * The appKey to use.
     * @return String
     */
    @Value.Default
    @SerializedName("appKey")
    public String getAppKey() {
        return "replace-with-app-key";
    }

    /**
     * The appSecret to use.
     * @return String
     */
    @Value.Default
    @SerializedName("appSecret")
    public String getAppSecret() {
        return "replace-with-secret";
    }

    /**
     * The cluster to use.
     * @return String
     */
    @Value.Default
    @SerializedName("cluster")
    public String getCluster() {
        return "replace-with-cluster";
    }

    /**
     * The appChannel to use.
     * @return String
     */
    @Value.Default
    @SerializedName("appChannel")
    public String getAppChannel() {
        return "replace-with-app-channel";
    }

    /**
     * The activityTimeout to use.
     * @return long
     */
    @Value.Default
    @SerializedName("activityTimeout")
    public Long getActivityTimeout() {
        return Constants.FOUR_THOUSAND;
    }
}
