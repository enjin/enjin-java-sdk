package io.enjincoin.sdk.client.vo.identity;

import com.google.gson.annotations.SerializedName;
import io.enjincoin.sdk.client.annotations.immutables.SkipNulls;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>Update Identity Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class UpdateIdentityRequestVO extends BaseIdentityRequestVO {

    /**
     * Method to get the updateMap.
     * @return Optional
     */
    @SkipNulls
    @SerializedName("update")
    public abstract Optional<Map<String, Object>> getUpdateMap();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "UpdateIdentityRequestVO [updateMap=" + getUpdateMap().orElse(null) + "]";
    }

}
