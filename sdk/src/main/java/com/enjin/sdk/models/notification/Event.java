package com.enjin.sdk.models.notification;

import com.enjin.sdk.models.notification.data.EventData;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Event {

    private String model;

    @SerializedName("event_type")
    private String eventType;

    @SerializedName("event_data")
    private EventData data;

}
