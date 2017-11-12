package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CancelTransactionRequestRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("txr_id")
    public abstract String getTxrId();

    @Override
    public String toString() {
        return "CancelTransactionRequestRequestVO [auth=" + getAuth() + ", txrId=" + getTxrId() + "]";
    }

}
