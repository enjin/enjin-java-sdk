package com.enjin.coin.sdk.vo.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEventRequestVO{

	@JsonProperty("auth")
	private String auth;
	
	@JsonProperty("event_id")
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
