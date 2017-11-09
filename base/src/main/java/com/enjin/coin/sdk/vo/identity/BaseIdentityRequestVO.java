package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class BaseIdentityRequestVO {

	@SerializedName("auth")
	private String auth;

	@SerializedName("identity")
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
