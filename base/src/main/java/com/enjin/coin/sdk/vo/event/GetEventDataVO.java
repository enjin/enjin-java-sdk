package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataVO {

    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

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

    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    @SerializedName("balances")
    public abstract Optional<GetEventDataBalancesVO[]> getGetEventDataBalancesVO();

}
