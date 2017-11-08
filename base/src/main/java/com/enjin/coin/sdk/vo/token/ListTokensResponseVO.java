package com.enjin.coin.sdk.vo.token;

import java.util.Arrays;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListTokensResponseVO extends BaseResponseVO{

	@JsonProperty("getTokenResponseVOArray")
	private GetTokenResponseVO[] getTokenResponseVOArray;

	public GetTokenResponseVO[] getGetTokenResponseVOArray() {
		return getTokenResponseVOArray;
	}

	public void setGetTokenResponseVOArray(GetTokenResponseVO[] getTokenResponseVOArray) {
		this.getTokenResponseVOArray = getTokenResponseVOArray;
	}

	@Override
	public String toString() {
		return "ListTokensResponseVO [getTokenResponseVOArray=" + Arrays.toString(getTokenResponseVOArray) + "]";
	}
	
	
}
