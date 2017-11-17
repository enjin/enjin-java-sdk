package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * List Transactions Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTransactionRequestsRequestVO {

    /**
     * Method to get the auth.
     * @return Optional<String>
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the identityMap.
     * @return Optional<Map<String, Object>>
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the appId.
     * @return Optional<String>
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

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
     * Method to get the afterTxrId.
     * @return Optional<String>
     */
    @SerializedName("after_txr_id")
    public abstract Optional<String> getAfterTxrId();

    /**
     * Method to get the limit.
     * @return Optional<String>
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Method to get the currency.
     * @return Optional<String>
     */
    @SerializedName("currency")
    public abstract Optional<String> getCurrency();

}
