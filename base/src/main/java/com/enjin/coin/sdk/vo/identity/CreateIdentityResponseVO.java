package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateIdentityResponseVO {

    @Nullable
    @SerializedName("identity_id")
    public abstract String getIdentityId();

    @Nullable
    @SerializedName("identity_code")
    public abstract String getIdentityCode();

    @Override
    public String toString() {
        return "CreateIdentityResponseVO [identityId=" + getIdentityId() + ", identityCode=" + getIdentityCode() + "]";
    }

}
