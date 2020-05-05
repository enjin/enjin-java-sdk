package com.enjin.sdk.models.wallet;

import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.services.wallet.WalletService;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a Trusted Platform Wallet.
 *
 * @see WalletService
 */
@ToString
@Getter
public class Wallet {

    /**
     * -- GETTER --
     * Returns the Ethereum address of the wallet.
     *
     * @return the Ethereum address
     */
    private String ethAddress;

    /**
     * -- GETTER --
     * Returns the wallet's Ethereum balance.
     *
     * @return the Ethereum balance
     */
    private BigDecimal ethBalance;

    /**
     * -- GETTER --
     * Returns the wallet's Enjin Coin balance.
     *
     * @return the Enjin coin balance
     */
    private BigDecimal enjBalance;

    /**
     * -- GETTER --
     * Returns the wallet's Enjin Coin allowance given to CryptoItems.
     *
     * @return the Enjin coin allowance
     */
    private BigDecimal enjAllowance;

    /**
     * -- GETTER --
     * Returns the balances held by the wallet.
     *
     * @return the balances
     */
    private List<Balance> balances;

    /**
     * -- GETTER --
     * Returns the tokens created by the wallet.
     *
     * @return the tokens created
     */
    private List<Token> tokensCreated;

}
