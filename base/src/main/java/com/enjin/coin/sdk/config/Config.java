package com.enjin.coin.sdk.config;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.enjin.coin.sdk.util.Constants;
import com.google.gson.annotations.SerializedName;

import java.io.File;

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
     * Get the notification config.
     * @return Platform
     */
    @Value.Default
    @SerializedName("notification")
    public Notification getNotification() {
        return ImmutableNotification.builder().build();
    }


    /**
     * Get the total executors.
     * @return Integer
     */
    @Value.Default
    @SerializedName("total-executors")
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

    /**
     * Loads a config if it exists or creates a new config with default values.
     *
     * @param file target destination
     * @return Config
     * @throws Exception
     */
    public static Config load(File file) throws Exception {
        return load(file, Config.class, () -> ImmutableConfig.builder().build());
    }

}
