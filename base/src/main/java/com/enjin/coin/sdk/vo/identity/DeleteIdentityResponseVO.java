package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class DeleteIdentityResponseVO {

    @SerializedName("result")
    public abstract Optional<Boolean> getResult();

    @Override
    public String toString() {
        return "DeleteIdentityResponseVO [result=" + getResult().orElse(null) + "]";
    }

}

