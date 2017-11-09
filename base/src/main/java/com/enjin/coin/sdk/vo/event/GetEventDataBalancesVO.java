package com.enjin.coin.sdk.vo.event;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class GetEventDataBalancesVO  {

	@SerializedName("identity")
	private Map<String, Object> identityMap;	
	
	@SerializedName("from")
	private Map<String, Object> fromMap;	
	
	@SerializedName("balance_pending")
	private Map<String, Object> balancePendingMap;	
	
	@SerializedName("balance_confirmed")
	private Map<String, Object> balanceConfirmedMap;

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

	public Map<String, Object> getBalancePendingMap() {
		return balancePendingMap;
	}

	public void setBalancePendingMap(Map<String, Object> balancePendingMap) {
		this.balancePendingMap = balancePendingMap;
	}

	public Map<String, Object> getBalanceConfirmedMap() {
		return balanceConfirmedMap;
	}

	public void setBalanceConfirmedMap(Map<String, Object> balanceConfirmedMap) {
		this.balanceConfirmedMap = balanceConfirmedMap;
	}	
	
	
}
