package io.enjincoin.sdk.client.config;

import java.io.File;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import io.enjincoin.sdk.client.util.Constants;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public class Config extends JsonConfig {


    @SerializedName("platform")
    private PlatformResponseBody trustedPlatform;

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
     * @return the trustedPlatform
     */
    public PlatformResponseBody getTrustedPlatform() {
        return trustedPlatform;
    }

    /**
     * @param trustedPlatform the trustedPlatform to set
     */
    public void setTrustedPlatform(PlatformResponseBody trustedPlatform) {
        this.trustedPlatform = trustedPlatform;
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
