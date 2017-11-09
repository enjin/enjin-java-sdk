package com.enjin.coin.sdk.vo.event;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class GetEventDataBalancesVO  {

	@SerializedName("identity")
	private Map<String, Object> identityMap;	
	
	@SerializedName("from")
	private Map<String, Object> fromMap;	
	
	@SerializedName("pending")
	private Map<String, Object> pendingMap;	
	
	@SerializedName("confirmed")
	private Map<String, Object> confirmedMap;

	public Map<String, Object> getIdentityMap() {
		return identityMap;
	}

	public void setIdentityMap(Map<String, Object> identityMap) {
		this.identityMap = identityMap;
	}
	
	
	public Map<String, Object> getFromMap() {
		return fromMap;
	}

	public void setFromMap(Map<String, Object> fromMap) {
		this.fromMap = fromMap;
	}

	public Map<String, Object> getPendingMap() {
		return pendingMap;
	}

	public void setPendingMap(Map<String, Object> pendingMap) {
		this.pendingMap = pendingMap;
	}

	public Map<String, Object> getConfirmedMap() {
		return confirmedMap;
	}

	public void setConfirmedMap(Map<String, Object> confirmedMap) {
		this.confirmedMap = confirmedMap;
	}	
	
	
}
