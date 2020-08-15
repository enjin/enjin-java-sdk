package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 */
public interface PlayerFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @return
     */
    default T withLinkingCode() {
        return set("withLinkingCode", true);
    }

    /**
     * TODO
     * @return
     */
    default T withLinkingCodeQr() {
        return set("withLinkingCodeQr", true);
    }

    /**
     * TODO
     * @param size
     * @return
     */
    default T qrSize(Integer size) {
        return set("linkingCodeQrSize", size);
    }

    /**
     * TODO
     * @return
     */
    default T withWallet() {
        return set("withPlayerWallet", true);
    }

}
