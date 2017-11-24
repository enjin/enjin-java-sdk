package com.enjin.coin.sdk.vo.identity;

import java.util.Map;
import java.util.Optional;

import org.immutables.gson.Gson;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Base Identity request class.
 * </p>
 */
@Gson.TypeAdapters
public abstract class BaseIdentityRequestVO {

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
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "BaseIdentityRequestVO [auth=" + getAuth().orElse(null) + ", identityMap=" + getIdentityMap().orElse(null) + "]";
    }

}
