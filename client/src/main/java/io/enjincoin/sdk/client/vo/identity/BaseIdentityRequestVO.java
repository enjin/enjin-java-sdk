package io.enjincoin.sdk.client.vo.identity;

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
     *
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the identityMap.
     *
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "BaseIdentityRequestVO [auth=" + this.getAuth().orElse(null) + ", identityMap=" + this.getIdentityMap().orElse(null) + "]";
    }

}
