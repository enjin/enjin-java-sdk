package io.enjincoin.sdk.client.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Create Transaction Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateTransactionRequestRequestVO {

    /**
     * Method to get the auth.
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the identityMap.
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the recipientMap.
     * @return Optional
     */
    @SerializedName("recipient")
    public abstract Optional<Map<String, Object>> getRecipientMap();

    /**
     * Method to get the type.
     * @return Optional
     */
    @SerializedName("type")
    public abstract Optional<String> getType();

    /**
     * Method to get the icon.
     * @return Optional
     */
    @SerializedName("icon")
    public abstract Optional<String> getIcon();

    /**
     * Method to get the title.
     * @return Optional
     */
    @SerializedName("title")
    public abstract Optional<String> getTitle();

    /**
     * Method to get the valueMap.
     * @return Optional
     */
    @SerializedName("value")
    public abstract Optional<Map<String, Object>> getValueMap();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "CreateTransactionRequestRequestVO [auth=" + getAuth().orElse(null) + ", identityMap=" + getIdentityMap().orElse(null) + ", recipientMap="
                + getRecipientMap().orElse(null) + ", type=" + getType().orElse(null) + ", icon=" + getIcon().orElse(null) + ", title="
                + getTitle().orElse(null) + ", valueMap=" + getValueMap().orElse(null) + "]";
    }

}
