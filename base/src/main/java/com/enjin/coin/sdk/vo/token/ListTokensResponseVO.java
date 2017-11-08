package com.enjin.coin.sdk.vo.token;

import java.util.Arrays;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListTokensResponseVO extends BaseResponseVO{

	@JsonProperty("getTokenResponseVOArray")
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
