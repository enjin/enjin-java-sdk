package com.enjin.coin.sdk.vo.platform;

import java.util.Map;
import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Get Platform Auth Details Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetPlatformAuthDetailsResponseVO {

    /**
     * Method to get the method.
     *
     * @return Optional
     */
    @SerializedName("method")
    public abstract Optional<String> getMethod();

    /**
     * Method to get the clientInfo.
     *
     * @return Optional
     */
    @SerializedName("client_info")
    public abstract Optional<Map<String, Object>> getClientInfoMap();

    /**
     * Method to get the channels.
     *
     * @return Optional
     */
    @SerializedName("channels")
    public abstract Optional<Map<String, Object>> getChannelsMap();

    /**
     * Method to get the role.
     *
     * @return Optional
     */
    @SerializedName("role")
    public abstract Optional<String> getRole();

}
