package io.enjincoin.sdk.client.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Create Identity Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateIdentityResponseVO {

    /**
     * Method to get the identityId.
     *
     * @return Optional
     */
    @SerializedName("identity_id")
    public abstract Optional<String> getIdentityId();

    /**
     * Method to get the identityCode.
     *
     * @return Optional
     */
    @SerializedName("identity_code")
    public abstract Optional<String> getIdentityCode();

    /**
     * Class toString method.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "CreateIdentityResponseVO [identityId=" + this.getIdentityId().orElse(null) + ", identityCode=" + this.getIdentityCode().orElse(null) + "]";
    }

}
