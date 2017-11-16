package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetIdentityResponseVO {

    @SerializedName("identity_id")
    public abstract Optional<String> getIdentityId();

    @SerializedName("ethereum_address")
    public abstract Optional<String> getEthereumAddress();

    @SerializedName("player_name")
    public abstract Optional<String> getPlayerName();

    @SerializedName("uuid")
    public abstract Optional<String> getUuid();

    @Override
    public String toString() {
        return "GetIdentityResponseVO [identityId=" + getIdentityId().orElse(null) + ", ethereumAddress=" + getEthereumAddress().orElse(null)
                + ", playerName=" + getPlayerName().orElse(null) + ", uuid=" + getUuid().orElse(null) + "]";
    }

}
