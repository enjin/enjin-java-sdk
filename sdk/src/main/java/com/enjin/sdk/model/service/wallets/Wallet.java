package com.enjin.sdk.model.service.wallets;

import com.enjin.sdk.model.service.balances.Balance;
import com.enjin.sdk.model.service.tokens.Token;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@ToString
@Getter
public class Wallet {

    private String ethAddress;

    private BigDecimal enjAllowance;

    private BigDecimal ethBalance;

    private BigDecimal enjBalance;

    private List<Balance> balances;

    private List<Token> tokensCreated;

}
