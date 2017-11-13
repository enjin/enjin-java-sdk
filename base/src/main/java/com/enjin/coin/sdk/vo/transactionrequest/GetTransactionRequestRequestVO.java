package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTransactionRequestRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    @SerializedName("txr_id")
    public abstract Optional<String> getTxrId();

    @Override
    public String toString() {
        return "GetTransactionRequestRequestVO [auth=" + getAuth().orElse(null) + ", txrId=" + getTxrId().orElse(null) + "]";
    }

}
