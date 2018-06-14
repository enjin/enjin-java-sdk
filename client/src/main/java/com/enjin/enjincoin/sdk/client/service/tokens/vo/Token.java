package com.enjin.enjincoin.sdk.client.service.tokens.vo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token_id")
    private Integer tokenId;

    @SerializedName("app_id")
    private Integer appId;

    private String creator;

    private String name;

    private String icon;

    private String totalSupply;

    private String exchangeRate;

    private Integer decimals;

    private String maxMeltFee;

    private String meltFee;

    private Integer transferable;

    private String supplyModel;

    private Integer firstBlock;

    private Integer blockHeight;

    @SerializedName("markedForDelete")
    private Boolean markedForDeletion;

    @SerializedName("created_at")
    private JsonObject createdAt;

    @SerializedName("updated_at")
    private JsonObject updatedAt;

    private Double balance;

    private Double availableToMint;

    public Integer getTokenId() {
        return this.tokenId;
    }

    public Integer getAppId() {
        return this.appId;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTotalSupply() {
        return this.totalSupply;
    }

    public String getExchangeRate() {
        return this.exchangeRate;
    }

    public Integer getDecimals() {
        return this.decimals;
    }

    public String getMaxMeltFee() {
        return this.maxMeltFee;
    }

    public String getMeltFee() {
        return this.meltFee;
    }

    public Integer getTransferable() {
        return this.transferable;
    }

    public String getSupplyModel() {
        return this.supplyModel;
    }

    public Integer getFirstBlock() {
        return this.firstBlock;
    }

    public Integer getBlockHeight() {
        return this.blockHeight;
    }

    public Boolean getMarkedForDeletion() {
        return this.markedForDeletion;
    }

    public JsonObject getCreatedAt() {
        return this.createdAt;
    }

    public JsonObject getUpdatedAt() {
        return this.updatedAt;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double getAvailableToMint() {
        return this.availableToMint;
    }
}
