package io.enjincoin.sdk.client.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Get Token Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenBalanceRequestVO {

    /**
     * Method to get the identityMap.
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the tokenIdsMap.
     * @return Optional
     */
    @SerializedName("token_ids")
    public abstract Optional<Map<String, Object>> getTokenIdsMap();


    @Override
    public String toString() {
        return "GetTokenBalanceRequestVO [getIdentityMap()=" + getIdentityMap() + ", getTokenIdsMap()=" + getTokenIdsMap() + "]";
    }

}
