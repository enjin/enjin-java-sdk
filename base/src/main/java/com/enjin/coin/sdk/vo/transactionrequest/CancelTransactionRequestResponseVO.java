package com.enjin.coin.sdk.vo.transactionrequest;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>
 * Cancel Transaction Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class CancelTransactionRequestResponseVO {

    /**
     * Method to get the result.
     * @return Optional
     */
    public abstract Optional<Boolean> getResult();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "CancelTransactionRequestResponseVO [result=" + getResult().orElse(null) + "]";
    }

}
