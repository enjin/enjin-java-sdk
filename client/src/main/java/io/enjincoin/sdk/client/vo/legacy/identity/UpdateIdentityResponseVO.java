package io.enjincoin.sdk.client.vo.legacy.identity;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.annotations.immutables.SkipNulls;
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
     *
     * @return Optional
     */
    @SkipNulls
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [identityMap=" + this.getIdentityMap().orElse(null) + "]";
    }

}
