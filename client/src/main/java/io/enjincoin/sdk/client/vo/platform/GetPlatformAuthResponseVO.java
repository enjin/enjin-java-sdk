package io.enjincoin.sdk.client.vo.platform;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

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
