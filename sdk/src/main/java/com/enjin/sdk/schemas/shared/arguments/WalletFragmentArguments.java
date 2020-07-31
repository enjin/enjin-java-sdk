package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 */
public interface WalletFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @return
     */
    default T withTokensCreated() {
        return set("withTokensCreated", true);
    }

}
