package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesRequestVO extends BaseIdentityRequestVO {

    @SerializedName("linked")
    public abstract Optional<Boolean> getLinked();

    @SerializedName("after_identity_id")
    public abstract Optional<String> getAfterIdentityId();

    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @Override
    public String toString() {
        return "ListIdentitiesRequestVO [linked=" + getLinked().orElse(null) + ", afterIdentityId=" + getAfterIdentityId().orElse(null)
                + ", limit=" + getLimit().orElse(null) + "]";
    }

}
