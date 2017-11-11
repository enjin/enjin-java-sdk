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

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getEthereumAddress() {
        return ethereumAddress;
    }

    public void setEthereumAddress(String ethereumAddress) {
        this.ethereumAddress = ethereumAddress;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "GetIdentityResponseVO [identityId=" + identityId + ", ethereumAddress=" + ethereumAddress
                + ", playerName=" + playerName + ", uuid=" + uuid + "]";
    }


}
