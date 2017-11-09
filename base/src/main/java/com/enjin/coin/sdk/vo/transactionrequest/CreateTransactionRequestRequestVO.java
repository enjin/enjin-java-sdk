package com.enjin.coin.sdk.vo.transactionrequest;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class CreateTransactionRequestRequestVO {

	@SerializedName("auth")
	private String auth;
	
	@SerializedName("identity")
	private Map<String, Object> identityMap;
	
	@SerializedName("recipient")
	private Map<String, Object> recipientMap;
	
	@SerializedName("type")
	private String type;
	@SerializedName("icon")
	private String icon;
	@SerializedName("title")
	private String title;
	
	@SerializedName("value")
	private Map<String, Object> valueMap;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Map<String, Object> getIdentityMap() {
		return identityMap;
	}

	public void setIdentityMap(Map<String, Object> identityMap) {
		this.identityMap = identityMap;
	}

	public Map<String, Object> getRecipientMap() {
		return recipientMap;
	}

	public void setRecipientMap(Map<String, Object> recipientMap) {
		this.recipientMap = recipientMap;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, Object> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, Object> valueMap) {
		this.valueMap = valueMap;
	}

	@Override
	public String toString() {
		return "CreateTransactionRequestRequestVO [auth=" + auth + ", identityMap=" + identityMap + ", recipientMap="
				+ recipientMap + ", type=" + type + ", icon=" + icon + ", title=" + title + ", valueMap=" + valueMap
				+ "]";
	}
	
	
}
