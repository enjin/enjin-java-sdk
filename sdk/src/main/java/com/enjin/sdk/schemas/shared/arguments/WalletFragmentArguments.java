package com.enjin.sdk.schemas.shared.arguments;

/**
 * Fragment interface used to request certain information from wallets returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Wallet
 */
public interface WalletFragmentArguments<T extends AssetFragmentArguments<T>>
        extends AssetFragmentArguments<T> {

    /**
     * Sets the request to include the assets the wallet created with the wallet.
     *
     * @return this request for chaining
     */
    default T withAssetsCreated() {
        return set("withAssetsCreated", true);
    }

}
