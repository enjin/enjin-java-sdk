package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteIdentityResponseVO extends BaseResponseVO{

	@JsonProperty("result")
	private boolean result;

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DeleteIdentityResponseVO [result=" + result + "]";
	}
	
	
}

