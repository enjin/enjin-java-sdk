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
     * The Ethereum address of the sender.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    default T ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

    // TODO: Replace arg type with boolean.
    /**
     * Sets whether the request will test the transaction before creating it.
     * <br>
     * <p>
     *     Setting this to false will skip checks, but may run the risk of losing gas fees if the transaction fails on
     *     the blockchain.
     * </p>
     *
     * @param test the test state
     * @return this request for chaining
     */
    default T test(String test) {
        return set("test", test);
    }

    // TODO: Replace arg type with boolean.
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
    default T send(String send) {
        return set("send", send);
    }

}
