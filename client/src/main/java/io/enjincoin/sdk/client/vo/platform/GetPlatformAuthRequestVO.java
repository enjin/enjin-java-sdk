package io.enjincoin.sdk.client.vo.platform;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

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
     *
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();


    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "GetPlatformAuthRequestVO [auth=" + this.getAuth().orElse(null) + "]";
    }

}
