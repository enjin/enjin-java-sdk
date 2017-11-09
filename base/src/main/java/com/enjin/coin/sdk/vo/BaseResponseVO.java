package com.enjin.coin.sdk.vo;

import java.util.HashMap;
import java.util.Map;

import wiremock.com.fasterxml.jackson.annotation.JsonAnyGetter;
import wiremock.com.fasterxml.jackson.annotation.JsonAnySetter;

public class BaseResponseVO {

	Map<String, Object> unknownFields = new HashMap<>();

	// Capture all other fields that Jackson do not match other members
	@JsonAnyGetter
	public Map<String, Object> getOtherFields() {
		return unknownFields;
	}

	@JsonAnySetter
	public void setOtherField(String name, Object value) {
		unknownFields.put(name, value);
	}
	
}

