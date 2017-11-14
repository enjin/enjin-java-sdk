package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateTransactionRequestRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

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
        return "CreateTransactionRequestRequestVO [auth=" + getAuth().orElse(null) + ", identityMap=" + getIdentityMap().orElse(null)
                + ", recipientMap=" + getRecipientMap().orElse(null) + ", type=" + getType().orElse(null)
                + ", icon=" + getIcon().orElse(null) + ", title=" + getTitle().orElse(null)
                + ", valueMap=" + getValueMap().orElse(null) + "]";
    }

}
