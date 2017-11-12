package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesResponseVO {

    @Nullable
    @SerializedName("identity_id")
    public abstract String getIdentityId();

    @Nullable
    @SerializedName("ethereum_address")
    public abstract String getEthereumAddress();

    @Nullable
    @SerializedName("player_name")
    public abstract String getPlayerName();

    @Override
    public String toString() {
        return "ListIdentitiesResponseVO [identityId=" + getIdentityId() + ", ethereumAddress=" + getEthereumAddress()
                + ", playerName=" + getPlayerName() + "]";
    }

}
