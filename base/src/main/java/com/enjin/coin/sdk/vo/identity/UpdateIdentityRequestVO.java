package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.SkipNulls;
import com.google.gson.annotations.SerializedName;
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
    public abstract Optional<Map<String, Object>> getUpdate();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "UpdateIdentityRequestVO [update=" + getUpdate().orElse(null) + "]";
    }

}
