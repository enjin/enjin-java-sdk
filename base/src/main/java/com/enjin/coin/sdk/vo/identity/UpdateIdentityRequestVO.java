package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class UpdateIdentityRequestVO extends BaseIdentityRequestVO{
	
	@SerializedName("update")
	private Map<String, Object> update;

	public Map<String, Object> getUpdate() {
		return update;
	}

	public void setUpdate(Map<String, Object> update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "UpdateIdentityRequestVO [update=" + update + "]";
	}
	
}
