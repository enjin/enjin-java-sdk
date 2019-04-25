package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;

@ToString
@Getter
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

    private Boolean isCreator;

    private BigInteger balance;

    private String index;

    private String availableToMint;

    private String itemURI;

}
