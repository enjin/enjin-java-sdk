package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * <p>Get Event Data Balances class.</p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataBalancesVO {

	/**
	 * Method to get the identityMap.
	 * @return Optional<Map<String, Object>>
	 */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

	/**
	 * Method to get the fromMap.
	 * @return Optional<Map<String, Object>>
	 */
    @SerializedName("from")
    public abstract Optional<Map<String, Object>> getFromMap();

	/**
	 * Method to get the pendingMap.
	 * @return Optional<Map<String, Object>>
	 */
    @SerializedName("pending")
    public abstract Optional<Map<String, Object>> getPendingMap();

	/**
	 * Method to get the confirmedMap.
	 * @return Optional<Map<String, Object>>
	 */
    @SerializedName("confirmed")
    public abstract Optional<Map<String, Object>> getConfirmedMap();

}
