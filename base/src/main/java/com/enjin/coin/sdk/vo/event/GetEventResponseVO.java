package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;

public class GetEventResponseVO  {

	@SerializedName("event_id")
	private String eventId;
	
	@SerializedName("event_type")
	private String eventType;
	
	@SerializedName("timestamp")
	private String timestamp;
	
	@SerializedName("app_id")
	private String appId;

	@SerializedName("data")
	private GetEventDataVO data;
	
	
	public GetEventDataVO getData() {
		return data;
	}

	public void setData(GetEventDataVO data) {
		this.data = data;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "GetEventResponseVO [eventId=" + eventId + ", eventType=" + eventType + ", timestamp=" + timestamp
				+ ", appId=" + appId + "]";
	}

	
}
