package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Base Identity request class.
 * </p>
 */
@Gson.TypeAdapters
public abstract class BaseIdentityRequestVO {

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
    public abstract Optional<Map<String, Object>> getIdentity();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "BaseIdentityRequestVO [auth=" + getAuth().orElse(null) + ", identity=" + getIdentity().orElse(null) + "]";
    }

}
