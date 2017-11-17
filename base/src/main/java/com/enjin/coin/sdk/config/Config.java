package com.enjin.coin.sdk.config;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.enjin.coin.sdk.util.Constants;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public class Config extends JsonConfig {

    /**
     * Get the trusted platform.
     * @return Platform
     */
    @Value.Default
    @SerializedName("platform")
    public Platform getTrustedPlatform() {
        return ImmutablePlatform.builder().build();
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
        return null;
    }

}
