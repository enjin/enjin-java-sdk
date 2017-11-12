package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.enjin.coin.sdk.annotations.immutables.SkipNulls;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class UpdateIdentityRequestVO extends BaseIdentityRequestVO {

    @Nullable
    @SkipNulls
    @SerializedName("update")
    public abstract Map<String, Object> getUpdate();

    @Override
    public String toString() {
        return "UpdateIdentityRequestVO [update=" + getUpdate() + "]";
    }

}
