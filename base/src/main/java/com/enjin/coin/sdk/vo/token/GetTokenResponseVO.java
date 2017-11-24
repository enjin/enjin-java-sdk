package com.enjin.coin.sdk.vo.token;

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
public abstract class GetTokenResponseVO {

    /**
     * Method to get the tokenDetailsResponseVO.
     * @return Optional
     */
    public abstract Optional<GetTokenDetailsResponseVO[]> getGetTokenDetailsResponseVO();

}
