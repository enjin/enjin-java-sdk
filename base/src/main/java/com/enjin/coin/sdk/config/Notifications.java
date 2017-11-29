package com.enjin.coin.sdk.config;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class Notifications {

    /**
     * The appId to use.
     * @return String
     */
    @SerializedName("appId")
    public abstract String getAppId();

    /**
     * The appKey to use.
     * @return String
     */
    @SerializedName("appKey")
    public abstract String getAppKey();

    /**
     * The appSecret to use.
     * @return String
     */
    @SerializedName("appSecret")
    public abstract String getAppSecret();

    /**
     * The cluster to use.
     * @return String
     */
    @SerializedName("cluster")
    public abstract String getCluster();

    /**
     * The appChannel to use.
     * @return String
     */
    @SerializedName("appChannel")
    public abstract String getAppChannel();

    /**
     * The activityTimeout to use.
     * @return long
     */
    @Value.Default
    @SerializedName("activityTimeout")
    public Long getActivityTimeout() {
        return 4000L;
    }
}
