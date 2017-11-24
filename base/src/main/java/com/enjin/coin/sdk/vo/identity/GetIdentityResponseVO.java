package com.enjin.coin.sdk.vo.identity;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>Get Identity Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetIdentityResponseVO {

    /**
     * Method to get the GetIdentityDetailsResponseVO.
     * @return Optional
     */
    public abstract Optional<GetIdentityDetailsResponseVO[]> getGetIdentityDetailsResponseVO();

}
