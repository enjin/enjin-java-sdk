package com.enjin.coin.sdk.vo.token;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenResponseVO {

    @Nullable
    @SerializedName("token_id")
    public abstract String getTokenId();

    @Nullable
    @SerializedName("creator")
    public abstract String getCreator();

    @Nullable
    @SerializedName("adapter")
    public abstract String getAdapter();

    @Nullable
    @SerializedName("name")
    public abstract String getName();

    @Nullable
    @SerializedName("icon")
    public abstract String getIcon();

    @Nullable
    @SerializedName("totalSupply")
    public abstract String getTotalSupply();

    @Nullable
    @SerializedName("exchangeRate")
    public abstract String getExchangeRate();

    @Nullable
    @SerializedName("decimals")
    public abstract String getDecimals();

    @Nullable
    @SerializedName("maxMeltFee")
    public abstract String getMaxMeltFee();

    @Nullable
    @SerializedName("meltFee")
    public abstract String getMeltFee();

    @Nullable
    @SerializedName("transferable")
    public abstract String getTransferable();

    @Override
    public String toString() {
        return "GetTokenResponseVO [tokenId=" + getTokenId() + ", creator=" + getCreator() + ", adapter=" + getAdapter() + ", name="
                + getName() + ", icon=" + getIcon() + ", totalSupply=" + getTotalSupply() + ", exchangeRate=" + getExchangeRate()
                + ", decimals=" + getDecimals() + ", maxMeltFee=" + getMaxMeltFee() + ", meltFee=" + getMeltFee() + ", transferable="
                + getTransferable() + "]";
    }

}
