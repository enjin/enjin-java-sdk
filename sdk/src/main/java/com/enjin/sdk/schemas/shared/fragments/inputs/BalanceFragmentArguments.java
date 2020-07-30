package com.enjin.sdk.schemas.shared.fragments.inputs;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 */
public interface BalanceFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @param balIdFormat
     * @return
     */
    default T balIdFormat(TokenIdFormat balIdFormat) {
        return set("balIdFormat", balIdFormat);
    }

    /**
     * TODO
     * @param balIndexFormat
     * @return
     */
    default T balIndexFormat(TokenIndexFormat balIndexFormat) {
        return set("balIndexFormat", balIndexFormat);
    }

    /**
     * TODO
     * @return
     */
    default T withBalProjectId() {
        return set("withBalAppId", true);
    }

    /**
     * TODO
     * @return
     */
    default T withBalWalletAddress() {
        return set("withBalWalletAddress", true);
    }

}

