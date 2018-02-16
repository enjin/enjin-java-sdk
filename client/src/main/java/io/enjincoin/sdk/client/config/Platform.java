package io.enjincoin.sdk.client.config;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.util.http.Protocol;
import io.enjincoin.sdk.client.util.http.ProtocolPort;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>
 * Config used throughout the sdk.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public class Platform {

    /**
     * The host to use.
     * @return String
     */
    @Value.Default
    @SerializedName("host")
    public String getHost() {
        return "localhost";
    }

    /**
     * The port to use.
     * @return Integer
     */
    @Value.Default
    @SerializedName("port")
    public Integer getPort() {
        return ProtocolPort.HTTPS;
    }

    /**
     * The protocol to use.
     * @return String.
     */
    @Value.Default
    @SerializedName("protocol")
    public String getProtocol() {
        return Protocol.HTTPS;
    }

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return String.format("%s://%s:%d/", getProtocol(), getHost(), getPort());
    }
}
