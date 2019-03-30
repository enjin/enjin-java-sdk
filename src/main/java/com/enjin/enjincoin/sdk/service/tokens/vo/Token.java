package com.enjin.enjincoin.sdk.service.tokens.vo;

import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("app_id")
    private Integer appId;

    private String name;

    private String creator;

    private String meltValue;

    private Integer meltFeeRatio;

    private Integer meltFeeMaxRatio;

    private TokenSupplyModel supplyModel;

    private String totalSupply;

    private String circulatingSupply;

    private String reserve;

    private TokenTransferable transferable;

    private TokenTransferFeeSettings transferFeeSettings;

    private Boolean nonFungible;

    private Integer firstBlock;

    private Integer blockHeight;

    @SerializedName("markedForDelete")
    private Boolean markedForDeletion;

    private Double balance;

    private String index;

    private Double availableToMint;

    private String itemURI;

    private String icon;

    /*
    ----- Methods -----
    */

    public String getTokenId() {
        return tokenId;
    }

    public Integer getAppId() {
        return appId;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public String getMeltValue() {
        return meltValue;
    }

    public Integer getMeltFeeRatio() {
        return meltFeeRatio;
    }

    public Integer getMeltFeeMaxRatio() {
        return meltFeeMaxRatio;
    }

    public TokenSupplyModel getSupplyModel() {
        return supplyModel;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public String getReserve() {
        return reserve;
    }

    public TokenTransferable getTransferable() {
        return transferable;
    }

    public TokenTransferFeeSettings getTransferFeeSettings() {
        return transferFeeSettings;
    }

    public Boolean getNonFungible() {
        return nonFungible;
    }

    public Integer getFirstBlock() {
        return firstBlock;
    }

    public Integer getBlockHeight() {
        return blockHeight;
    }

    public Boolean getMarkedForDeletion() {
        return markedForDeletion;
    }

    public Double getBalance() {
        return balance;
    }

    public String getIndex() {
        return index;
    }

    public Double getAvailableToMint() {
        return availableToMint;
    }

    public String getItemURI() {
        return itemURI;
    }

    public String getIcon() {
        return icon;
    }
}
