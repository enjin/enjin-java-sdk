package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

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
     * @return Optional<Boolean>
     */
    @SerializedName("result")
    public abstract Optional<Boolean> getResult();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "CancelTransactionRequestResponseVO [result=" + getResult().orElse(null) + "]";
    }

}
