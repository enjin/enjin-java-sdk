package com.enjin.coin.sdk.vo.platform;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Get Platform Auth Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetPlatformAuthResponseVO {

    /**
     * Method to get the PlatformAuthDetails.
     *
     * @return Optional
     */
    @SerializedName("notifications")
    public abstract Optional<GetPlatformAuthDetailsResponseVO> getPlatformAuthNotificationDetails();

}
