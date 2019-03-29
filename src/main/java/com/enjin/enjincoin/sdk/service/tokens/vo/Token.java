package com.enjin.enjincoin.sdk.service.tokens.vo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("app_id")
    private Integer appId;

    private String creator;

    private String name;

    private Integer decimals;

    private String symbol;

    private String totalSupply;

    private String initialSupply;

    private TokenSupplyModel supplyModel;

    private String meltValue;

    private String meltFeePercentage;

    private TokenTransferable transferable;

    private TokenTransferFeeSettings transferFeeSettings;

    private Boolean nonFungible;

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

    public String getTokenId() {
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

    public Integer getDecimals() {
        return this.decimals;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTotalSupply() {
        return this.totalSupply;
    }

    public String getInitialSupply() {
        return this.initialSupply;
    }

    public TokenSupplyModel getSupplyModel() {
        return this.supplyModel;
    }

    public String getMeltValue() {
        return this.meltValue;
    }

    public String getMeltFeePercentage() {
        return this.meltFeePercentage;
    }

    public TokenTransferable getTransferable() {
        return this.transferable;
    }

    public TokenTransferFeeSettings getTransferFeeSettings() {
        return this.transferFeeSettings;
    }

    public Boolean getNonFungible() {
        return this.nonFungible;
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
