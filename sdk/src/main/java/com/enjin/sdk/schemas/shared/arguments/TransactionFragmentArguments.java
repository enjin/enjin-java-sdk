package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 */
public interface TransactionFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @return
     */
    default T withMeta() {
        return set("withMeta", true);
    }

    /**
     * TODO
     * @return
     */
    default T withEncodedData() {
        return set("withEncodedData", true);
    }

    /**
     * TODO
     * @return
     */
    default T withTokenData() {
        return set("withTokenData", true);
    }

    /**
     * TODO
     * @return
     */
    default T withSignedTxs() {
        return set("withSignedTxs", true);
    }

    /**
     * TODO
     * @return
     */
    default T withError() {
        return set("withError", true);
    }

    /**
     * TODO
     * @return
     */
    default T withNonce() {
        return set("withNonce", true);
    }

    /**
     * TODO
     * @return
     */
    default T withState() {
        return set("withState", true);
    }

    /**
     * TODO
     * @return
     */
    default T withReceipt() {
        return set("withReceipt", true);
    }

}
