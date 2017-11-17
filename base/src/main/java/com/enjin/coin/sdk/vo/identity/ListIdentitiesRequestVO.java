package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>List Identities Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesRequestVO extends BaseIdentityRequestVO {

    /**
     * Method to get the linked value.
     * @return Optional
     */
    @SerializedName("linked")
    public abstract Optional<Boolean> getLinked();

    /**
     * Method to get the afterIdentityId.
     * @return Optional
     */
    @SerializedName("after_identity_id")
    public abstract Optional<String> getAfterIdentityId();

    /**
     * Method to get the limit.
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "ListIdentitiesRequestVO [linked=" + getLinked().orElse(null) + ", afterIdentityId=" + getAfterIdentityId().orElse(null) + ", limit="
                + getLimit().orElse(null) + "]";
    }

}
