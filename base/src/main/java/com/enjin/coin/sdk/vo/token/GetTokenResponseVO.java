package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenResponseVO {

    @SerializedName("token_id")
    public abstract Optional<String> getTokenId();

    @SerializedName("creator")
    public abstract Optional<String> getCreator();

    @SerializedName("adapter")
    public abstract Optional<String> getAdapter();

    @SerializedName("name")
    public abstract Optional<String> getName();

    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    @SerializedName("totalSupply")
    public abstract Optional<String> getTotalSupply();

    @SerializedName("exchangeRate")
    public abstract Optional<String> getExchangeRate();

    @SerializedName("decimals")
    public abstract Optional<String> getDecimals();

    @SerializedName("maxMeltFee")
    public abstract Optional<String> getMaxMeltFee();

    @SerializedName("meltFee")
    public abstract Optional<String> getMeltFee();

    @SerializedName("transferable")
    public abstract Optional<String> getTransferable();

    @Override
    public String toString() {
        return "GetTokenResponseVO [tokenId=" + getTokenId().orElse(null) + ", creator=" + getCreator().orElse(null)
                + ", adapter=" + getAdapter().orElse(null) + ", name=" + getName().orElse(null)
                + ", icon=" + getIcon().orElse(null) + ", totalSupply=" + getTotalSupply().orElse(null)
                + ", exchangeRate=" + getExchangeRate().orElse(null) + ", decimals=" + getDecimals().orElse(null)
                + ", maxMeltFee=" + getMaxMeltFee().orElse(null) + ", meltFee=" + getMeltFee().orElse(null)
                + ", transferable=" + getTransferable().orElse(null) + "]";
    }

}
