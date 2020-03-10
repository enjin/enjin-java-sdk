package com.enjin.sdk.model.service.balances;

import com.enjin.sdk.model.service.identities.Identity;
import com.enjin.sdk.model.service.wallets.Wallet;
import com.enjin.sdk.model.service.tokens.Token;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Balance {

    private String id;

    private String index;

    private Integer value;

    private Token token;

    private Identity identity;

    private Wallet wallet;

}
