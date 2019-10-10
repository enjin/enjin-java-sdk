package com.enjin.sdk.model.service.notifications;

import com.enjin.sdk.model.service.requests.TransactionType;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventData {

    private Integer id;
    private String transactionId;
    private String transactionType;
    private TransactionType requestType;
    private String eventType;
    private String param1;
    private String param2;
    private String param3;
    private String param4;

}
