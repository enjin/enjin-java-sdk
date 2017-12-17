package com.enjin.coin.sdk.vo.token;

import java.util.Map;
import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

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
