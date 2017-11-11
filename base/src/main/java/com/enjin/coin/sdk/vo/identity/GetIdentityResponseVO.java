package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

public class GetIdentityResponseVO {

    @SerializedName("identity_id")
    private String identityId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("player_name")
    private String playerName;

    @SerializedName("uuid")
    private String uuid;

    public String getIdentityId() {
        return identityId;
    }

    public String getEthereumAddress() {
        return ethereumAddress;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "GetIdentityResponseVO [identityId=" + identityId + ", ethereumAddress=" + ethereumAddress
                + ", playerName=" + playerName + ", uuid=" + uuid + "]";
    }


}
