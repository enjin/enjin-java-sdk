package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.AssetIdFormat;
import com.enjin.sdk.models.AssetIndexFormat;

/**
 * Fragment interface used to request certain information from balances returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Balance
 */
public interface BalanceFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the desired asset ID format.
     *
     * @param balIdFormat the format
     * @return this request for chaining
     */
    default T balIdFormat(AssetIdFormat balIdFormat) {
        return set("balIdFormat", balIdFormat);
    }

    /**
     * Sets the desired index format for non-fungible assets.
     *
     * @param balIndexFormat the format
     * @return this request for chaining
     */
    default T balIndexFormat(AssetIndexFormat balIndexFormat) {
        return set("balIndexFormat", balIndexFormat);
    }

    /**
     * Sets the request to include the application ID with the balance.
     *
     * @return this request for chaining
     */
    default T withBalProjectId() {
        return set("withBalAppId", true);
    }

    /**
     * Sets the request to include the wallet address with the balance.
     *
     * @return this request for chaining
     */
    default T withBalWalletAddress() {
        return set("withBalWalletAddress", true);
    }

}

