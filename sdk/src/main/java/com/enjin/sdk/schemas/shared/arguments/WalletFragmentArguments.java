package com.enjin.sdk.schemas.shared.arguments;

/**
 * Fragment interface used to request certain information from wallets returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Wallet
 */
public interface WalletFragmentArguments<T extends TokenFragmentArguments<T>>
        extends TokenFragmentArguments<T> {

    /**
     * Sets the request to include the tokens (items) the wallet created with the wallet.
     *
     * @return this request for chaining
     */
    default T withTokensCreated() {
        return set("withTokensCreated", true);
    }

}
