package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Create Transaction Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateTransactionRequestResponseVO {

    /**
     * Method to get the txrId.
     * @return Optional<String>
     */
    @SerializedName("txr_id")
    public abstract Optional<String> getTxrId();

    /**
     * Method to get the identityMap.
     * @return Optional<Map<String, Object>>
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the recipientMap.
     * @return Optional<Map<String, Object>>
     */
    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    /**
     * Method to get the type.
     * @return Optional<String>
     */
    @SerializedName("type")
    public abstract Optional<String> getType();

    /**
     * Method to get the icon.
     * @return Optional<String>
     */
    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    /**
     * Method to get the title.
     * @return Optional<String>
     */
    @SerializedName("title")
    public abstract Optional<String> getTitle();

    /**
     * Method to get the value.
     * @return Optional<String>
     */
    @SerializedName("value")
    public abstract Optional<Map<String, Object>> getValueMap();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "CreateTransactionRequestResponseVO [txrId=" + getTxrId().orElse(null) + ", identityMap=" + getIdentityMap().orElse(null) + ", recipientMap="
                + getRecipientMap().orElse(null) + ", type=" + getType().orElse(null) + ", icon=" + getIcon().orElse(null) + ", title="
                + getTitle().orElse(null) + ", valueMap=" + getValueMap().orElse(null) + "]";
    }

}
