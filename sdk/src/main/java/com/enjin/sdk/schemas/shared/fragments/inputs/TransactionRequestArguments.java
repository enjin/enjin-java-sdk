package com.enjin.sdk.schemas.shared.fragments.inputs;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 * @param <T>
 */
public interface TransactionRequestArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

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
