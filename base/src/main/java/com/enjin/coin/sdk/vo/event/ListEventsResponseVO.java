package com.enjin.coin.sdk.vo.event;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class ListEventsResponseVO {

	@SerializedName("getEventResponseVOArray")
	private GetEventResponseVO[] getEventsResponseVOArray;

	public GetEventResponseVO[] getGetEventsResponseVOArray() {
		return getEventsResponseVOArray;
	}

	public void setGetEventsResponseVOArray(GetEventResponseVO[] getEventsResponseVOArray) {
		this.getEventsResponseVOArray = getEventsResponseVOArray;
	}

	@Override
	public String toString() {
		return "ListEventsResponseVO [getEventsResponseVOArray=" + Arrays.toString(getEventsResponseVOArray) + "]";
	}

	
}
