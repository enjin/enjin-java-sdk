package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTransactionRequestsRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("identity")
    public abstract Map<String, Object> getIdentityMap();

    @Nullable
    @SerializedName("app_id")
    public abstract String getAppId();

    @Nullable
    @SerializedName("recipient")
    public abstract Map<String, Object> getRecipientMap();

    @Nullable
    @SerializedName("type")
    public abstract String getType();

    @Nullable
    @SerializedName("after_txr_id")
    public abstract String getAfterTxrId();

    @Nullable
    @SerializedName("limit")
    public abstract String getLimit();

    @Nullable
    @SerializedName("currency")
    public abstract String getCurrency();

}
