package com.enjin.sdk.models.token;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@ToString
@Getter
public class Token {

    private String id;

    private String index;

    private String name;

    private Integer appId;

    private Boolean nonFungible;

    private String creator;

    private Integer blockHeight;

    private Integer firstBlock;

    private String icon;

    private Integer meltFeeRatio;

    private Integer meltFeeMaxRatio;

    private BigInteger meltValue;

    private Boolean markedForDelete;

    private Boolean availableToMint;

    private String reserve;

    private TokenSupplyModel supplyModel;

    private BigInteger circulatingSupply;

    private BigInteger totalSupply;

    private TokenTransferFeeSettings transferFeeSettings;

    private TokenTransferable transferable;

    private String itemURI;

    private String createdAt;

    private String updatedAt;

}
