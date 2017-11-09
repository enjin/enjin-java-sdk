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

	@Override
	public String toString() {
		return "ListIdentitiesResponseVO [identityId=" + identityId + ", ethereumAddress=" + ethereumAddress
				+ ", playerName=" + playerName + "]";
	}

	
}
