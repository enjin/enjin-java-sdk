package com.enjin.sdk.models.token.event;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TokenEvent {

    private Integer id;

    private String tokenId;

    private TokenEventType event;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private Integer blockNumber;

}
