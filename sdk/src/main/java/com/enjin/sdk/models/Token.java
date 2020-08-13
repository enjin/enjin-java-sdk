package com.enjin.sdk.models;

import lombok.Getter;

import java.util.Collection;

/**
 * TODO
 */
@Getter
public class Token {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String id;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String name;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer blockHeight;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String creator;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer firstBlock;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer meltFeeRatio;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer meltFeeMaxRatio;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String meltValue;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String metadataUri;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Boolean nonfungible;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String reserve;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private TokenSupplyModel supplyModel;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String circulatingSupply;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String mintableSupply;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String totalSupply;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private TokenTransferable transferable;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private TokenTransferFeeSettings transferFeeSettings;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private TokenVariantMode variantMode;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Collection<TokenVariant> variants;

}
