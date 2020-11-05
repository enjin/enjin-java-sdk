package com.enjin.sdk.schemas.shared.arguments;

/**
 * Fragment interface used to request certain information from players returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Player
 */
public interface PlayerFragmentArguments<T extends WalletFragmentArguments<T>>
        extends WalletFragmentArguments<T> {

    /**
     * Sets the request to include the linking information with the player.
     *
     * @return this request for chaining
     * @see PlayerFragmentArguments#qrSize(Integer) 
     */
    default T withLinkingInfo() {
        return set("withLinkingInfo", true);
    }

    /**
     * Sets the desired size of the QR image in pixels. To be used with
     * {@link PlayerFragmentArguments#withLinkingInfo()}.
     *
     * @param size the size
     * @return this request for chaining
     */
    default T qrSize(Integer size) {
        return set("linkingCodeQrSize", size);
    }

    /**
     * Sets the request to include the wallet with the player.
     *
     * @return this request for chaining
     */
    default T withWallet() {
        return set("withPlayerWallet", true);
    }

}
