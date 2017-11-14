package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CancelTransactionRequestResponseVO {

    @SerializedName("result")
    public abstract Optional<Boolean> getResult();

    @Override
    public String toString() {
        return "CancelTransactionRequestResponseVO [result=" + getResult().orElse(null) + "]";
    }

}
