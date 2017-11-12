package com.enjin.coin.sdk.vo.transactionrequest;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTransactionRequestResponseVO {

    @Nullable
    @SerializedName("txr_id")
    public abstract String getTxrId();

    @Nullable
    @SerializedName("identity")
    public abstract Map<String, Object> getIdentityMap();

    @Nullable
    @SerializedName("recipient")
    public abstract Map<String, Object> getRecipientMap();

    @Nullable
    @SerializedName("type")
    public abstract String getType();

    @Nullable
    @SerializedName("icon")
    public abstract String getIcon();

    @Nullable
    @SerializedName("title")
    public abstract String getTitle();

    @Nullable
    @SerializedName("value")
    public abstract Map<String, Object> getValueMap();

    @Override
    public String toString() {
        return "GetTransactionRequestResponseVO [txrId=" + getTxrId() + ", identityMap=" + getIdentityMap() + ", recipientMap="
                + getRecipientMap() + ", type=" + getType() + ", icon=" + getIcon() + ", title=" + getTitle() + ", valueMap=" + getValueMap()
                + "]";
    }

}
