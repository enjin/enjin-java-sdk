package com.enjin.sdk.models.wallet;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.balance.BalanceFragment;
import com.enjin.sdk.models.token.TokenFragment;
import com.enjin.sdk.services.wallet.WalletService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see WalletService
 * @param <T> the super type of the interface
 */
public interface WalletFragment<T extends GraphQLVariableHolder<T>>
        extends GraphQLVariableHolder<T>, BalanceFragment<T>, TokenFragment<T> {

    /**
     * Sets the request to include the application id of the balances held by the wallet in the response.
     *
     * @param val the app id
     * @return    this request
     */
    default T balAppId(int val) {
        set("balAppId", val);
        return (T) this;
    }

    /**
     * Sets the request to include the token id of the balances held by the wallet in the response.
     *
     * @param val the token id
     * @return    this request
     */
    default T balTokenId(String val) {
        set("balTokenId", val);
        return (T) this;
    }

    /**
     * Sets the request to include the balances held by the wallet in the response that are equal to the passed value.
     *
     * @param val the value the balances must equal
     * @return    this request
     */
    default T balVal(int val) {
        set("balVal", val);
        return (T) this;
    }

    /**
     * Sets the request to include the balances held by the wallet in the response that are greater than the passed value.
     *
     * @param val the value the balances must be greater than
     * @return    this request
     */
    default T balGt(int val) {
        set("balGt", val);
        return (T) this;
    }

    /**
     * Sets the request to include the balances held by the wallet in the response that are greater than or equal to the passed value.
     *
     * @param val the value the balances must be greater or equal to
     * @return    this request
     */
    default T balGte(int val) {
        set("balGte", val);
        return (T) this;
    }

    /**
     * Sets the request to include the balances held by the wallet in the response that are less than the passed value.
     *
     * @param val the value the balances must be less than
     * @return    this request
     */
    default T balLt(int val) {
        set("balLt", val);
        return (T) this;
    }

    /**
     * Sets the request to include the balances held by the wallet in the response that are less than or equal to the passed value.
     *
     * @param val the value the balances must be less than or equal to
     * @return    this request
     */
    default T balLte(int val) {
        set("balLte", val);
        return (T) this;
    }

    /**
     * Sets the request to include balances held by the wallet in the response.
     *
     * @return this request
     */
    default T withBalances() {
        set("withBalances", true);
        return (T) this;
    }

    /**
     * Sets the request to include the tokens created by the wallet in the response.
     *
     * @return this request
     */
    default T withTokensCreated() {
        set("withTokensCreated", true);
        return (T) this;
    }

}
