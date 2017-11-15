package com.enjin.coin.sdk.config;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>Config used throughout the sdk</p>
 * @author damien
 *
 */
@Value.Immutable
@Gson.TypeAdapters
public class Config extends JsonConfig {

    @Value.Default
    @SerializedName("platform")
    public Platform getTrustedPlatform() {
        return ImmutablePlatform.builder().build();
    }

    @Nullable
    @Value.Default
    @SerializedName("test-mode")
    public Boolean isInTestMode() {
        return null;
    }

}
