package com.enjin.sdk.schemas.project.arguments;

import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Interface used to set common arguments used in transaction requests in the project schema.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Request
 */
public interface ProjectTransactionRequestArguments<T extends TransactionFragmentArguments<T>>
        extends TransactionFragmentArguments<T> {

    /**
     * Sets the Ethereum address of the sender.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    default T ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
