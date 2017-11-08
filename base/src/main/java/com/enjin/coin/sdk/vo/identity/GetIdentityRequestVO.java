package com.enjin.coin.sdk.vo.identity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetIdentityRequestVO extends BaseIdentityRequestVO{

	@JsonProperty("auth")
	private String auth;
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "GetIdentityRequestVO [auth=" + auth + "]";
	}
}
