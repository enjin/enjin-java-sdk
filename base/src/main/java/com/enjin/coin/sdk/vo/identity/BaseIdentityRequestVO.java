package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseIdentityRequestVO {

	@JsonProperty("auth")
	private String auth;

	@JsonProperty("identity")
	private Map<String, Object> identity;
	public Map<String, Object> getIdentity() {
		return identity;
	}

	public void setIdentity(Map<String, Object> identity) {
		this.identity = identity;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "BaseIdentityRequestVO [auth=" + auth + ", identity=" + identity + "]";
	}
	
}
