package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class CreateIdentityResponseVO {

    @SerializedName("identity_id")
    public abstract Optional<String> getIdentityId();

    @SerializedName("identity_code")
    public abstract Optional<String> getIdentityCode();

    @Override
    public String toString() {
        return "CreateIdentityResponseVO [identityId=" + getIdentityId().orElse(null) + ", identityCode=" + getIdentityCode().orElse(null) + "]";
    }

}
