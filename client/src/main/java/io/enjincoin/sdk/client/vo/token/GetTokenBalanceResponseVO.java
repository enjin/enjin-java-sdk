package io.enjincoin.sdk.client.vo.token;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

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
     *
     * @return Optional
     */
    //@SerializedName("token_ids")
    public abstract Optional<Map<String, BigDecimal>> getTokenBalanceMap();

    @Override
    public String toString() {
        return "GetTokenBalanceResponseVO [getTokenBalanceMap()=" + this.getTokenBalanceMap() + "]";
    }


}
