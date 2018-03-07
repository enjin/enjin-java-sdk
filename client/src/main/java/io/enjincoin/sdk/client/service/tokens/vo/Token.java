package io.enjincoin.sdk.client.service.tokens.vo;

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
        return tokenId;
    }

    /**
     * @return the appId
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @return the adapter
     */
    public String getAdapter() {
        return adapter;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @return the totalSupply
     */
    public Integer getTotalSupply() {
        return totalSupply;
    }

    /**
     * @return the exchangeRate
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @return the decimals
     */
    public Integer getDecimals() {
        return decimals;
    }

    /**
     * @return the maxMeltFee
     */
    public BigDecimal getMaxMeltFee() {
        return maxMeltFee;
    }

    /**
     * @return the meltFee
     */
    public BigDecimal getMeltFee() {
        return meltFee;
    }

    /**
     * @return the transferable
     */
    public Integer getTransferable() {
        return transferable;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TokenResponseBody [tokenId=" + tokenId + ", appId=" + appId + ", creator=" + creator + ", adapter=" + adapter + ", name=" + name + ", icon=" + icon + ", totalSupply="
                + totalSupply + ", exchangeRate=" + exchangeRate + ", decimals=" + decimals + ", maxMeltFee=" + maxMeltFee + ", meltFee=" + meltFee + ", transferable=" + transferable
                + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }
}
