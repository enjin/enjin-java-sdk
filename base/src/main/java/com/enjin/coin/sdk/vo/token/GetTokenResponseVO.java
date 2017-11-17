package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Get Token Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenResponseVO {

    /**
     * Method to get the tokenId.
     * @return Optional<String>
     */
    @SerializedName("token_id")
    public abstract Optional<String> getTokenId();

    /**
     * Method to get the creator.
     * @return Optional<String>
     */
    @SerializedName("creator")
    public abstract Optional<String> getCreator();

    /**
     * Method to get the adapter.
     * @return Optional<String>
     */
    @SerializedName("adapter")
    public abstract Optional<String> getAdapter();

    /**
     * Method to get the name.
     * @return Optional<String>
     */
    @SerializedName("name")
    public abstract Optional<String> getName();

    /**
     * Method to get the icon.
     * @return Optional<String>
     */
    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    /**
     * Method to get the totalSupply.
     * @return Optional<String>
     */
    @SerializedName("totalSupply")
    public abstract Optional<String> getTotalSupply();

    /**
     * Method to get the exchangeRate.
     * @return Optional<String>
     */
    @SerializedName("exchangeRate")
    public abstract Optional<String> getExchangeRate();

    /**
     * Method to get the decimals.
     * @return Optional<String>
     */
    @SerializedName("decimals")
    public abstract Optional<String> getDecimals();

    /**
     * Method to get the maxMeltFee.
     * @return Optional<String>
     */
    @SerializedName("maxMeltFee")
    public abstract Optional<String> getMaxMeltFee();

    /**
     * Method to get the meltFee.
     * @return Optional<String>
     */
    @SerializedName("meltFee")
    public abstract Optional<String> getMeltFee();

    /**
     * Method to get the transferable.
     * @return Optional<String>
     */
    @SerializedName("transferable")
    public abstract Optional<String> getTransferable();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetTokenResponseVO [tokenId=" + getTokenId().orElse(null) + ", creator=" + getCreator().orElse(null) + ", adapter=" + getAdapter().orElse(null)
                + ", name=" + getName().orElse(null) + ", icon=" + getIcon().orElse(null) + ", totalSupply=" + getTotalSupply().orElse(null) + ", exchangeRate="
                + getExchangeRate().orElse(null) + ", decimals=" + getDecimals().orElse(null) + ", maxMeltFee=" + getMaxMeltFee().orElse(null) + ", meltFee="
                + getMeltFee().orElse(null) + ", transferable=" + getTransferable().orElse(null) + "]";
    }

}
