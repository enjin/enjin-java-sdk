package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTransactionRequestsRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    @SerializedName("type")
    public abstract Optional<String> getType();

    @SerializedName("after_txr_id")
    public abstract Optional<String> getAfterTxrId();

    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @SerializedName("currency")
    public abstract Optional<String> getCurrency();

}
