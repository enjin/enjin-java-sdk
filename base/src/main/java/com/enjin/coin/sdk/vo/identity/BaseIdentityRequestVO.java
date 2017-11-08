package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseIdentityRequestVO {

	@JsonProperty("identity")
	private Map<String, Object> identity;
	public Map<String, Object> getIdentity() {
		return identity;
	}

	public void setIdentity(Map<String, Object> identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "BaseIdentityRequestVO [identity=" + identity + "]";
	}
	
	
	
}
