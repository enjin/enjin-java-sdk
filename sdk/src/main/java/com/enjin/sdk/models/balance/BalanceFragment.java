package com.enjin.sdk.models.balance;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.services.balance.BalancesService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see BalancesService
 * @param <T> the super type of the interface
 */
public interface BalanceFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T> {

    /**
     * Sets the format to render the token balance id in the response.
     *
     * @param val the token id format
     * @return    this request
     */
    default T balIdFormat(String val) {
        set("balIdFormat", val);
        return (T) this;
    }

    /**
     * Sets the format to render the token balance index in the response.
     *
     * @param val the token index format
     * @return    this request
     */
    default T balIndexFormat(String val) {
        set("balIndexFormat", val);
        return (T) this;
    }

}
