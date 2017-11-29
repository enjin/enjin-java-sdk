package com.enjin.coin.sdk.config;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.enjin.coin.sdk.util.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public class Config extends JsonConfig {

    /**
     * Get the trusted platform config.
     * @return Platform
     */
    @Value.Default
    @SerializedName("platform")
    public Platform getTrustedPlatform() {
        return ImmutablePlatform.builder().build();
    }

    /**
     * Get the notifications config.
     * @return Platform
     */
    @Value.Default
    @SerializedName("notifications")
    public Notifications getNotifications() {
        return ImmutableNotifications.builder().build();
    }


    /**
     * Get the total executors.
     * @return Integer
     */
    @Value.Default
    @SerializedName("totalExecutors")
    public Integer getTotalExecutors() {
        return Constants.ONE;
    }

    /**
     * Get whether in test mode or not.
     * @return Boolean
     */
    @Nullable
    @Value.Default
    @SerializedName("test-mode")
    public Boolean isInTestMode() {
        return false;
    }

}
