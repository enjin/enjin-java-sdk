package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Get Event Data class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataVO {

    /**
     * Method to get the identityMap.
     * @return Optional<Map<String, Object>>
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

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
     * Method to get the tokenSupply.
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
     * Method to get the recipientMap.
     * @return Optional<Map<String, Object>>
     */
    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    /**
     * Method to get the balances.
     * @return Optional<GetEventDataBalancesVO[]>
     */
    @SerializedName("balances")
    public abstract Optional<GetEventDataBalancesVO[]> getGetEventDataBalancesVO();

}
