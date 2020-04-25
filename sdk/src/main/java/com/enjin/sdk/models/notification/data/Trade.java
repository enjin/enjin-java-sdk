package com.enjin.sdk.models.notification.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Trade {

    private String id;
    private Object from;
    private Object to;

}
