package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class UpdateIdentityResponseVO {

	@SerializedName("identity")
	private Map<String, Object> identityMap;	
	
	public Map<String, Object> getIdentityMap() {
		return identityMap;
	}

	public void setIdentityMap(Map<String, Object> identityMap) {
		this.identityMap = identityMap;
	}
}
