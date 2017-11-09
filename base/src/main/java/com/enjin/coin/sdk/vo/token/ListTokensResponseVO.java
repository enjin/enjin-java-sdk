package com.enjin.coin.sdk.vo.token;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class ListTokensResponseVO {

	@SerializedName("getTokenResponseVOArray")
	private GetTokenResponseVO[] getTokensResponseVOArray;

	public GetTokenResponseVO[] getGetTokensResponseVOArray() {
		return getTokensResponseVOArray;
	}

	public void setGetTokensResponseVOArray(GetTokenResponseVO[] getTokensResponseVOArray) {
		this.getTokensResponseVOArray = getTokensResponseVOArray;
	}

	@Override
	public String toString() {
		return "ListTokensResponseVO [getTokensResponseVOArray=" + Arrays.toString(getTokensResponseVOArray) + "]";
	}
	
	
}
