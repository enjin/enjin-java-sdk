package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GetEventDataVO {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("creator")
    private String creator;

    @SerializedName("adapter")
    private String adapter;

    @SerializedName("name")
    private String name;

    @SerializedName("icon")
    private String icon;

    @SerializedName("totalSupply")
    private String totalSupply;

    @SerializedName("exchangeRate")
    private String exchangeRate;

    @SerializedName("decimals")
    private String decimals;

    @SerializedName("maxMeltFee")
    private String maxMeltFee;

    @SerializedName("meltFee")
    private String meltFee;

    @SerializedName("transferable")
    private String transferable;


    @SerializedName("recipient")
    private Map<String, Object> recipientMap;


    @SerializedName("balances")
    private GetEventDataBalancesVO[] getEventDataBalancesVOArray;

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    public String getTokenId() {
        return tokenId;
    }
    public String getCreator() {
        return creator;
    }
    public String getAdapter() {
        return adapter;
    }
    public String getName() {
        return name;
    }
    public String getIcon() {
        return icon;
    }
    public String getTotalSupply() {
        return totalSupply;
    }
    public String getExchangeRate() {
        return exchangeRate;
    }
    public String getDecimals() {
        return decimals;
    }
    public String getMaxMeltFee() {
        return maxMeltFee;
    }
    public String getMeltFee() {
        return meltFee;
    }
    public String getTransferable() {
        return transferable;
    }
    public Map<String, Object> getRecipientMap() {
        return recipientMap;
    }
    public GetEventDataBalancesVO[] getGetEventDataBalancesVO() {
        return getEventDataBalancesVOArray;
    }

}
