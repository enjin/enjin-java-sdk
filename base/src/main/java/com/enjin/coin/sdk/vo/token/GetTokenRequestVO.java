package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;

public class GetTokenRequestVO{

	@SerializedName("token_id")
	private String tokenId;

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Override
	public String toString() {
		return "GetTokenRequestVO [tokenId=" + tokenId + "]";
	}
	
	

}
