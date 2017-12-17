package com.enjin.coin.sdk.vo.token;

import java.util.Map;
import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>
 * Get Token Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenBalanceResponseVO {
    /**
     * Method to get the tokenIdsMap.
     * @return Optional
     */
    //@SerializedName("token_ids")
    public abstract Optional<Map<String, Object>> getTokenBalanceMap();

    @Override
    public String toString() {
        return "GetTokenBalanceResponseVO [getTokenBalanceMap()=" + getTokenBalanceMap() + "]";
    }


}
