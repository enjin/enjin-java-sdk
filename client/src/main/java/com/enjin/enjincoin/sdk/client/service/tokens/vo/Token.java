package com.enjin.enjincoin.sdk.client.service.tokens.vo;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Token Response class.
 * </p>
 */
public class Token {

    @SerializedName("token_id")
    private Integer tokenId;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("creator")
    private String creator;

    @SerializedName("adapter")
    private String adapter;

    @SerializedName("name")
    private String name;

    @SerializedName("icon")
    private String icon;

    @SerializedName("totalSupply")
    private Integer totalSupply;

    @SerializedName("exchangeRate")
    private String exchangeRate;

    @SerializedName("decimals")
    private Integer decimals;

    @SerializedName("maxMeltFee")
    private BigDecimal maxMeltFee;

    @SerializedName("meltFee")
    private BigDecimal meltFee;

    @SerializedName("transferable")
    private Integer transferable;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    /**
     * Class constructor.
     * @param tokenId
     * @param appId
     * @param creator
     * @param adapter
     * @param name
     * @param icon
     * @param totalSupply
     * @param exchangeRate
     * @param decimals
     * @param maxMeltFee
     * @param meltFee
     * @param transferable
     * @param updatedAt
     * @param createdAt
     */
    public Token(Integer tokenId, Integer appId, String creator, String adapter, String name, String icon,
                 Integer totalSupply, String exchangeRate, Integer decimals, BigDecimal maxMeltFee, BigDecimal meltFee,
                 Integer transferable, String updatedAt, String createdAt) {
        super();
        this.tokenId = tokenId;
        this.appId = appId;
        this.creator = creator;
        this.adapter = adapter;
        this.name = name;
        this.icon = icon;
        this.totalSupply = totalSupply;
        this.exchangeRate = exchangeRate;
        this.decimals = decimals;
        this.maxMeltFee = maxMeltFee;
        this.meltFee = meltFee;
        this.transferable = transferable;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Token(Integer tokenId, Integer appId) {
        this(tokenId, appId, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * @return the tokenId
     */
    public Integer getTokenId() {
        return this.tokenId;
    }

    /**
     * @return the appId
     */
    public Integer getAppId() {
        return this.appId;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return this.creator;
    }

    /**
     * @return the adapter
     */
    public String getAdapter() {
        return this.adapter;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * @return the totalSupply
     */
    public Integer getTotalSupply() {
        return this.totalSupply;
    }

    /**
     * @return the exchangeRate
     */
    public String getExchangeRate() {
        return this.exchangeRate;
    }

    /**
     * @return the decimals
     */
    public Integer getDecimals() {
        return this.decimals;
    }

    /**
     * @return the maxMeltFee
     */
    public BigDecimal getMaxMeltFee() {
        return this.maxMeltFee;
    }

    /**
     * @return the meltFee
     */
    public BigDecimal getMeltFee() {
        return this.meltFee;
    }

    /**
     * @return the transferable
     */
    public Integer getTransferable() {
        return this.transferable;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return this.createdAt;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TokenResponseBody [tokenId=" + this.tokenId + ", appId=" + this.appId + ", creator=" + this.creator + ", adapter=" + this.adapter + ", name=" + this.name + ", icon=" + this.icon + ", totalSupply="
                + this.totalSupply + ", exchangeRate=" + this.exchangeRate + ", decimals=" + this.decimals + ", maxMeltFee=" + this.maxMeltFee + ", meltFee=" + this.meltFee + ", transferable=" + this.transferable
                + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + "]";
    }
}
