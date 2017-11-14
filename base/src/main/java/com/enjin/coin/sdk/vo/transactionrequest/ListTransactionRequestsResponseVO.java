package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTransactionRequestsResponseVO {

    @SerializedName("txr_id")
    public abstract Optional<String> getTxrId();

    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    @SerializedName("type")
    public abstract Optional<String> getType();

    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    @SerializedName("title")
    public abstract Optional<String> getTitle();

    @SerializedName("value")
    public abstract Optional<Map<String, Object>> getValueMap();

    @Override
    public String toString() {
        return "ListTransactionRequestsResponseVO [txrId=" + getTxrId().orElse(null) + ", identityMap=" + getIdentityMap().orElse(null)
                + ", recipientMap=" + getRecipientMap().orElse(null) + ", type=" + getType().orElse(null)
                + ", icon=" + getIcon().orElse(null) + ", title=" + getTitle().orElse(null)
                + ", valueMap=" + getValueMap().orElse(null) + "]";
    }

}
