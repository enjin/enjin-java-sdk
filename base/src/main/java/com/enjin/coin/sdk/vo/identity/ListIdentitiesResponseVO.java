package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesResponseVO {

    @SerializedName("identity_id")
    public abstract Optional<String> getIdentityId();

    @SerializedName("ethereum_address")
    public abstract Optional<String> getEthereumAddress();

    @SerializedName("player_name")
    public abstract Optional<String> getPlayerName();

    @Override
    public String toString() {
        return "ListIdentitiesResponseVO [identityId=" + getIdentityId().orElse(null) + ", ethereumAddress=" + getEthereumAddress().orElse(null)
                + ", playerName=" + getPlayerName().orElse(null) + "]";
    }

}
