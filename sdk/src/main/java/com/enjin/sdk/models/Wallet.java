package com.enjin.sdk.models;

import lombok.Getter;

import java.util.Collection;

/**
 * TODO
 */
@Getter
public class Wallet {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String ethAddress;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Float enjAllowance;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Float enjBalance;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Float ethBalance;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Collection<Token> tokensCreated;

}
