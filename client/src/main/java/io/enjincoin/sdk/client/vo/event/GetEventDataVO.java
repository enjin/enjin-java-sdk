package io.enjincoin.sdk.client.vo.event;

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
     *
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the tokenId.
     *
     * @return Optional
     */
    @SerializedName("token_id")
    public abstract Optional<String> getTokenId();

    /**
     * Method to get the creator.
     *
     * @return Optional
     */
    @SerializedName("creator")
    public abstract Optional<String> getCreator();

    /**
     * Method to get the adapter.
     *
     * @return Optional
     */
    @SerializedName("adapter")
    public abstract Optional<String> getAdapter();

    /**
     * Method to get the name.
     *
     * @return Optional
     */
    @SerializedName("name")
    public abstract Optional<String> getName();

    /**
     * Method to get the icon.
     *
     * @return Optional
     */
    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    /**
     * Method to get the tokenSupply.
     *
     * @return Optional
     */
    @SerializedName("totalSupply")
    public abstract Optional<String> getTotalSupply();

    /**
     * Method to get the exchangeRate.
     *
     * @return Optional
     */
    @SerializedName("exchangeRate")
    public abstract Optional<String> getExchangeRate();

    /**
     * Method to get the decimals.
     *
     * @return Optional
     */
    @SerializedName("decimals")
    public abstract Optional<String> getDecimals();

    /**
     * Method to get the maxMeltFee.
     *
     * @return Optional
     */
    @SerializedName("maxMeltFee")
    public abstract Optional<String> getMaxMeltFee();

    /**
     * Method to get the meltFee.
     *
     * @return Optional
     */
    @SerializedName("meltFee")
    public abstract Optional<String> getMeltFee();

    /**
     * Method to get the transferable.
     *
     * @return Optional
     */
    @SerializedName("transferable")
    public abstract Optional<String> getTransferable();

    /**
     * Method to get the recipientMap.
     *
     * @return Optional
     */
    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    /**
     * Method to get the balances.
     *
     * @return Optional
     */
    @SerializedName("balances")
    public abstract Optional<GetEventDataBalancesVO[]> getGetEventDataBalancesVO();

    /**
     * Method to get the txrId.
     *
     * @return Optional
     */
    @SerializedName("txr_id")
    public abstract Optional<String> getTxrId();

    /**
     * Method to get the type.
     *
     * @return Optional
     */
    @SerializedName("type")
    public abstract Optional<String> getType();

    /**
     * Method to get the title.
     *
     * @return Optional
     */
    @SerializedName("title")
    public abstract Optional<String> getTitle();

    /**
     * Method to get the valueMap.
     *
     * @return Optional
     */
    @SerializedName("value")
    public abstract Optional<Map<String, Object>> getValueMap();

    /**
     * Method to get the fromMap.
     *
     * @return Optional
     */
    @SerializedName("from")
    public abstract Optional<Map<String, Object>> getFromMap();

    /**
     * Method to get the pendingMap.
     *
     * @return Optional
     */
    @SerializedName("pending")
    public abstract Optional<Map<String, Object>> getPendingMap();

    /**
     * Method to get the confirmedMap.
     *
     * @return Optional
     */
    @SerializedName("confirmed")
    public abstract Optional<Map<String, Object>> getConfirmedMap();

    /**
     * Method to get the title.
     *
     * @return Optional
     */
    @SerializedName("state")
    public abstract Optional<String> getState();

    /**
     * Method to get the enj.
     *
     * @return Optional
     */
    @SerializedName("ENJ")
    public abstract Optional<String> getEnj();

    @Override
    public String toString() {
        return "GetEventDataVO [getIdentityMap()=" + getIdentityMap() + ", getTokenId()=" + getTokenId() + ", getCreator()=" + getCreator() + ", getAdapter()="
                + getAdapter() + ", getName()=" + getName() + ", getIcon()=" + getIcon() + ", getTotalSupply()=" + getTotalSupply() + ", getExchangeRate()="
                + getExchangeRate() + ", getDecimals()=" + getDecimals() + ", getMaxMeltFee()=" + getMaxMeltFee() + ", getMeltFee()=" + getMeltFee()
                + ", getTransferable()=" + getTransferable() + ", getRecipientMap()=" + getRecipientMap() + ", getGetEventDataBalancesVO()="
                + getGetEventDataBalancesVO() + ", getTxrId()=" + getTxrId() + ", getType()=" + getType() + ", getTitle()=" + getTitle() + ", getValueMap()="
                + getValueMap() + ", getState()=" + getState() + "]";
    }
}
