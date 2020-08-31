package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * Fragment interface used to request certain information from transactions returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Request
 */
public interface TransactionFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the request to include the metadata with the transaction.
     *
     * @return this request for chaining
     */
    default T withMeta() {
        return set("withMeta", true);
    }

    /**
     * Sets the request to include the encoded data with the transaction.
     *
     * @return this request for chaining
     */
    default T withEncodedData() {
        return set("withEncodedData", true);
    }

    /**
     * Sets the request to include the token (item) data with the transaction.
     *
     * @return this request for chaining
     */
    default T withTokenData() {
        return set("withTokenData", true);
    }

    /**
     * Sets the request to include the signed transactions with the transaction.
     *
     * @return this request for chaining
     */
    default T withSignedTxs() {
        return set("withSignedTxs", true);
    }

    /**
     * Sets the request to include the error with the transaction.
     *
     * @return this request for chaining
     */
    default T withError() {
        return set("withError", true);
    }

    /**
     * Sets the request to include the nonce with the transaction.
     *
     * @return this request for chaining
     */
    default T withNonce() {
        return set("withNonce", true);
    }

    /**
     * Sets the request to include the state with the transaction.
     *
     * @return this request for chaining
     */
    default T withState() {
        return set("withState", true);
    }

    /**
     * Sets the request to include the receipt with the transaction.
     *
     * @return this request for chaining
     */
    default T withReceipt() {
        return set("withReceipt", true);
    }

}
