package com.enjin.coin.sdk.vo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class BaseResponseVO {

	Map<String, String> unknownFields = new HashMap<>();

	// Capture all other fields that Jackson do not match other members
	@JsonAnyGetter
	public Map<String, String> getOtherFields() {
		return unknownFields;
	}

	@JsonAnySetter
	public void setOtherField(String name, String value) {
		unknownFields.put(name, value);
	}
	
}

