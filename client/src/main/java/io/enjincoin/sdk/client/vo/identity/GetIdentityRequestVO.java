package io.enjincoin.sdk.client.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Get Identity Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetIdentityRequestVO extends BaseIdentityRequestVO {

    /**
     * Method to get the linked value.
     *
     * @return Optional
     */
    @SerializedName("linked")
    public abstract Optional<Boolean> getLinked();

    /**
     * Method to get the after_identity_id value.
     *
     * @return Optional
     */
    @SerializedName("after_identity_id")
    public abstract Optional<String> getAfterIdentityId();

    /**
     * Method to get the limit value.
     *
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @Override
    public String toString() {
        return "GetIdentityRequestVO [getLinked()=" + this.getLinked() + ", getAfterIdentityId()=" + this.getAfterIdentityId() + ", getLimit()=" + this.getLimit() + "]";
    }

}
