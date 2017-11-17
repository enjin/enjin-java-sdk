package com.enjin.coin.sdk.config;

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
public class Ethereum {

    /**
     * mode to use.
     * 
     * @return String
     */
    @Value.Default
    @SerializedName("mode")
    public String getMode() {
        return "geth_ipc";
    }

    /**
     * geth path.
     * 
     * @return String
     */
    @Value.Default
    @SerializedName("path")
    public String getPath() {
        return "\\\\.\\pipe\\geth.ipc";
    }

}
