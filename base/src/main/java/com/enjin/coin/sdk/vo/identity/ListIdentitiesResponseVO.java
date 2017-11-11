package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

public class ListIdentitiesResponseVO {

    @SerializedName("identity_id")
    private String identityId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("player_name")
    private String playerName;

    public String getIdentityId() {
        return identityId;
    }

    public String getEthereumAddress() {
        return ethereumAddress;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "ListIdentitiesResponseVO [identityId=" + identityId + ", ethereumAddress=" + ethereumAddress
                + ", playerName=" + playerName + "]";
    }


}
