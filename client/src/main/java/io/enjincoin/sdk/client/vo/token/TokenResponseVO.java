package io.enjincoin.sdk.client.vo.token;

import java.math.BigDecimal;
import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Token Response class.
 * </p>
 */
public class TokenResponseVO {

    @SerializedName("token_id")
    private Optional<Integer> tokenId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("creator")
    private Optional<String> creator;

    @SerializedName("adapter")
    private Optional<String> adapter;

    @SerializedName("name")
    private Optional<String> name;

    @SerializedName("icon")
    private Optional<String> icon;

    @SerializedName("totalSupply")
    private Optional<Integer> totalSupply;

    @SerializedName("exchangeRate")
    private Optional<String> exchangeRate;

    @SerializedName("decimals")
    private Optional<Integer> decimals;

    @SerializedName("maxMeltFee")
    private Optional<BigDecimal> maxMeltFee;

    @SerializedName("meltFee")
    private Optional<BigDecimal> meltFee;

    @SerializedName("transferable")
    private Optional<Integer> transferable;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;

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
    public TokenResponseVO(Optional<Integer> tokenId, Optional<Integer> appId, Optional<String> creator, Optional<String> adapter, Optional<String> name, Optional<String> icon,
            Optional<Integer> totalSupply, Optional<String> exchangeRate, Optional<Integer> decimals, Optional<BigDecimal> maxMeltFee, Optional<BigDecimal> meltFee,
            Optional<Integer> transferable, Optional<String> updatedAt, Optional<String> createdAt) {
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

    /**
     * @return the tokenId
     */
    public Optional<Integer> getTokenId() {
        return tokenId;
    }

    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
    }

    /**
     * @return the creator
     */
    public Optional<String> getCreator() {
        return creator;
    }

    /**
     * @return the adapter
     */
    public Optional<String> getAdapter() {
        return adapter;
    }

    /**
     * @return the name
     */
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return the icon
     */
    public Optional<String> getIcon() {
        return icon;
    }

    /**
     * @return the totalSupply
     */
    public Optional<Integer> getTotalSupply() {
        return totalSupply;
    }

    /**
     * @return the exchangeRate
     */
    public Optional<String> getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @return the decimals
     */
    public Optional<Integer> getDecimals() {
        return decimals;
    }

    /**
     * @return the maxMeltFee
     */
    public Optional<BigDecimal> getMaxMeltFee() {
        return maxMeltFee;
    }

    /**
     * @return the meltFee
     */
    public Optional<BigDecimal> getMeltFee() {
        return meltFee;
    }

    /**
     * @return the transferable
     */
    public Optional<Integer> getTransferable() {
        return transferable;
    }

    /**
     * @return the updatedAt
     */
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TokenResponseVO [tokenId=" + tokenId + ", appId=" + appId + ", creator=" + creator + ", adapter=" + adapter + ", name=" + name + ", icon=" + icon + ", totalSupply="
                + totalSupply + ", exchangeRate=" + exchangeRate + ", decimals=" + decimals + ", maxMeltFee=" + maxMeltFee + ", meltFee=" + meltFee + ", transferable=" + transferable
                + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }
}
