package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesRequestVO extends BaseIdentityRequestVO {

    @Nullable
    @SerializedName("linked")
    public abstract Boolean getLinked();

    @Nullable
    @SerializedName("after_identity_id")
    public abstract String getAfterIdentityId();

    @Nullable
    @SerializedName("limit")
    public abstract String getLimit();

    @Override
    public String toString() {
        return "ListIdentitiesRequestVO [linked=" + getLinked() + ", afterIdentityId=" + getAfterIdentityId()
                + ", limit=" + getLimit() + "]";
    }

}
