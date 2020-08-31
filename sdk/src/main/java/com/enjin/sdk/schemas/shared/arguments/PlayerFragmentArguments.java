package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * Fragment interface used to request certain information from players returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Player
 */
public interface PlayerFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the request to include the linking code with the player.
     *
     * @return this request for chaining
     */
    default T withLinkingCode() {
        return set("withLinkingCode", true);
    }

    /**
     * Sets the request to include the URL to the QR linking code with the player.
     *
     * @return this request for chaining
     */
    default T withLinkingCodeQr() {
        return set("withLinkingCodeQr", true);
    }

    /**
     * Sets the desired size of the QR image in pixels.
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
