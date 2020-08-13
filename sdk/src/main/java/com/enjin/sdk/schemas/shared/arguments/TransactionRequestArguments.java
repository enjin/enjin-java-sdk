package com.enjin.sdk.schemas.shared.arguments;

/**
 * TODO
 * @param <T>
 */
public interface TransactionRequestArguments<T extends TransactionFragmentArguments<T>>
        extends TransactionFragmentArguments<T> {

    /**
     * TODO
     * @param ethAddress
     * @return
     */
    default T ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

    /**
     * TODO
     * @param test
     * @return
     */
    default T test(String test) {
        return set("test", test);
    }

    /**
     * TODO
     * @param send
     * @return
     */
    default T send(String send) {
        return set("send", send);
    }

}
