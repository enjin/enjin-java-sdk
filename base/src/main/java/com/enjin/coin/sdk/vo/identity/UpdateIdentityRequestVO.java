package com.enjin.coin.sdk.vo.identity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateIdentityRequestVO extends BaseIdentityRequestVO{
	
	@JsonProperty("update")
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
