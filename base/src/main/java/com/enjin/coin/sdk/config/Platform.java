package com.enjin.coin.sdk.config;

import com.enjin.coin.sdk.util.http.Protocol;
import com.enjin.coin.sdk.util.http.ProtocolPort;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public class Platform {

    @Value.Default
    @SerializedName("host")
    public String getHost() {
        return "localhost";
    }

    @Value.Default
    @SerializedName("port")
    public Integer getPort() {
        return ProtocolPort.HTTPS;
    }

    @Value.Default
    @SerializedName("protocol")
    public String getProtocol() {
        return Protocol.HTTPS;
    }

    @Override
    public String toString() {
        return String.format("%s://%s:%d/", getProtocol(), getHost(), getPort());
    }
}
