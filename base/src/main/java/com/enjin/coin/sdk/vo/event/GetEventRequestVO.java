package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;

public class GetEventRequestVO{

	@SerializedName("auth")
	private String auth;
	
	@SerializedName("event_id")
	private String eventId;

	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "GetEventRequestVO [auth=" + auth + ", eventId=" + eventId + "]";
	}



}
