package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CancelTransactionRequestResponseVO {

    @Nullable
    @SerializedName("result")
    public abstract Boolean getResult();

    @Override
    public String toString() {
        return "CancelTransactionRequestResponseVO [result=" + getResult() + "]";
    }

}
