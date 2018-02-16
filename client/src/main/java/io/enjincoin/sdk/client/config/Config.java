package io.enjincoin.sdk.client.config;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.annotations.immutables.Nullable;
import io.enjincoin.sdk.client.util.Constants;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

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
     *
     * @return Platform
     */
    @Value.Default
    @SerializedName("platform")
    public Platform getTrustedPlatform() {
        return ImmutablePlatform.builder().build();
    }

    /**
     * Get the total executors.
     *
     * @return Integer
     */
    @Value.Default
    @SerializedName("total-executors")
    public Integer getTotalExecutors() {
        return Constants.ONE;
    }

    /**
     * Get whether in test mode or not.
     *
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
     *
     * @return Config
     *
     * @throws Exception to be thrown
     */
    public static Config load(final File file) throws Exception {
        return load(file, Config.class, () -> ImmutableConfig.builder().build());
    }

}
