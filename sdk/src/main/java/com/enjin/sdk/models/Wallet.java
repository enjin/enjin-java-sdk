package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;

/**
 * Models a wallet on the platform.
 */
@EqualsAndHashCode
@Getter
public class Wallet {

    /**
     * -- Getter --
     * @return the Ethereum address of this wallet
     */
    private String ethAddress;

    /**
     * -- Getter --
     * @return the ENJ allowance given to crypto items
     */
    private Float enjAllowance;

    /**
     * -- Getter --
     * @return the ENJ balance for this wallet
     */
    private Float enjBalance;

    /**
     * -- Getter --
     * @return the ETH balance for this wallet
     */
    private Float ethBalance;

    /**
     * -- Getter --
     * @return the tokens (items) this wallet has created
     */
    private Collection<Token> tokensCreated;

}
