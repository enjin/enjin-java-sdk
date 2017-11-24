package com.enjin.coin.sdk.vo.transactionrequest;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Get Transaction Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTransactionRequestResponseVO {

    /**
     * Method to get the transactionRequestDetailsResponseVO.
     * @return Optional
     */
    public abstract Optional<GetTransactionRequestDetailsResponseVO[]> getTransactionRequestDetailsResponseVO();

    /**
     * Method to get the id.
     * @return Optional
     */
    @SerializedName("id")
    public abstract Optional<String> getId();


}
