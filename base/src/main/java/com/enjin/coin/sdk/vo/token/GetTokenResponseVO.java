package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;

public class GetTokenResponseVO {

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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDecimals() {
        return decimals;
    }

    public void setDecimals(String decimals) {
        this.decimals = decimals;
    }

    public String getMaxMeltFee() {
        return maxMeltFee;
    }

    public void setMaxMeltFee(String maxMeltFee) {
        this.maxMeltFee = maxMeltFee;
    }

    public String getMeltFee() {
        return meltFee;
    }

    public void setMeltFee(String meltFee) {
        this.meltFee = meltFee;
    }

    public String getTransferable() {
        return transferable;
    }

    public void setTransferable(String transferable) {
        this.transferable = transferable;
    }

    @Override
    public String toString() {
        return "GetTokenResponseVO [tokenId=" + tokenId + ", creator=" + creator + ", adapter=" + adapter + ", name="
                + name + ", icon=" + icon + ", totalSupply=" + totalSupply + ", exchangeRate=" + exchangeRate
                + ", decimals=" + decimals + ", maxMeltFee=" + maxMeltFee + ", meltFee=" + meltFee + ", transferable="
                + transferable + "]";
    }


}
