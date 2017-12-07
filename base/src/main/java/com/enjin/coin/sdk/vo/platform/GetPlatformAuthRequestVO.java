package com.enjin.coin.sdk.vo.platform;

import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Get Event Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetPlatformAuthRequestVO {


    /**
     * Method to get the auth.
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();


    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "GetPlatformAuthRequestVO [auth=" + getAuth().orElse(null) + "]";
    }

}
