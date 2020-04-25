package com.enjin.sdk.models.notification.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Token {

    private String id;
    private String name;
    private int circulatingSupply;
    private boolean nonFungible;
    private int reserve;
    private int supply;

}
