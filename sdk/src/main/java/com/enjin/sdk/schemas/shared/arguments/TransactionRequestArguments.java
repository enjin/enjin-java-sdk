package com.enjin.sdk.schemas.shared.arguments;

/**
 * Interface used to set common arguments used in transaction requests.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Request
 */
public interface TransactionRequestArguments<T extends TransactionFragmentArguments<T>>
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

    /**
     * Sets whether the request will send the transaction to the blockchain.
     * <br>
     * <p>
     *     Setting this to false allows for arguments to be tried out without hitting the blockchain.
     * </p>
     *
     * @param send the send state
     * @return this request for chaining
     */
    default T send(boolean send) {
        return set("send", send);
    }

}
