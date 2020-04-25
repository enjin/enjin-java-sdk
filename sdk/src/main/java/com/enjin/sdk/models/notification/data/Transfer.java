package com.enjin.sdk.models.notification.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Transfer {

    private String from;
    private String to;
    private String index;
    private String value;

}
