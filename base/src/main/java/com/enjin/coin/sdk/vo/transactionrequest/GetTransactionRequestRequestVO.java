package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTransactionRequestRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("txr_id")
    public abstract String getTxrId();

    @Override
    public String toString() {
        return "GetTransactionRequestRequestVO [auth=" + getAuth() + ", txrId=" + getTxrId() + "]";
    }

}
