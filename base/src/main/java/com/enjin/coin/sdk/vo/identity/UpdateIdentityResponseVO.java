package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.SkipNulls;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>Update Identity Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class UpdateIdentityResponseVO {

    /**
     * Method to get the identityMap.
     * @return Optional<Map<String, Object>>
     */
    @SkipNulls
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [identityMap=" + getIdentityMap().orElse(null) + "]";
    }

}
