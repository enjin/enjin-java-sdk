package com.enjin.sdk.models.wallet;

import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.token.Token;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@ToString
@Getter
public class Wallet {

    private String ethAddress;

    private BigDecimal ethBalance;

    private BigDecimal enjBalance;

    private BigDecimal enjAllowance;

    private List<Balance> balances;

    private List<Token> tokensCreated;

}
