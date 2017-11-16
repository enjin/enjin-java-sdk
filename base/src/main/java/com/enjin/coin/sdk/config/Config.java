package com.enjin.coin.sdk.config;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.enjin.coin.sdk.util.Constants;
import com.google.gson.annotations.SerializedName;

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

    @Value.Default
    @SerializedName("totalExecutors")
    public Integer getTotalExecutors() {
        return Constants.ONE;
    }
    
    
    @Nullable
    @Value.Default
    @SerializedName("test-mode")
    public Boolean isInTestMode() {
        return null;
    }

}
