package com.enjin.coin.sdk.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetIdentityRequestVO extends BaseResponseVO{

	@JsonProperty("auth")
	private String auth;

	@JsonProperty("identity")
	private Map<String, Object> identity;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Map<String, Object> getIdentity() {
		return identity;
	}

	public void setIdentity(Map<String, Object> identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "GetIdentityRequestVO [auth=" + auth + "]";
	}
}
