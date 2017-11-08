package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEventResponseVO extends BaseResponseVO {

	@JsonProperty("event_id")
	private String eventId;
	
	@JsonProperty("event_type")
	private String eventType;
	
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("app_id")
	private String appId;

	@JsonProperty("data")
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
