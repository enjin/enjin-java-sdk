package com.enjin.sdk.models.balance;

import com.enjin.sdk.services.balance.BalancesService;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform Balance.
 *
 * @see BalancesService
 */
@Getter
@ToString
public class Balance {

    /**
     * -- GETTER --
     * Returns the token's id.
     *
     * @return the token id
     */
    private String id;

    /**
     * -- GETTER --
     * Returns the token's index.
     *
     * @return the token index
     */
    private String index;

    /**
     * -- GETTER --
     * Returns the balance of the token.
     *
     * @return the balance
     */
    private Integer value;

}
