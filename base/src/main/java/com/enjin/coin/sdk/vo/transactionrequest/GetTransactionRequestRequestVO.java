package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Get Transaction Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTransactionRequestRequestVO {

    /**
     * Method to get the auth.
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the txrId.
     * @return Optional
     */
    @SerializedName("txr_id")
    public abstract Optional<String> getTxrId();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetTransactionRequestRequestVO [auth=" + getAuth().orElse(null) + ", txrId=" + getTxrId().orElse(null) + "]";
    }

}
