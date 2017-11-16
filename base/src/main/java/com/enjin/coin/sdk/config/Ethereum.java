package com.enjin.coin.sdk.config;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public class Ethereum {

    @Value.Default
    @SerializedName("mode")
    public String getMode() {
        return "geth_ipc";
    }

    @Value.Default
    @SerializedName("path")
    public String getPath() {
        return "\\\\.\\pipe\\geth.ipc";
    }

}
