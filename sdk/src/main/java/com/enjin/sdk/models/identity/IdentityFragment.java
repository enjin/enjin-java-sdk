package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.wallet.WalletFragment;
import com.enjin.sdk.services.identity.IdentitiesService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see IdentitiesService
 * @param <T> the super type of the interface
 */
public interface IdentityFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T>, WalletFragment<T> {

    /**
     * Sets the request to include the identity's linking code in the response.
     *
     * @return this request
     */
    default T withLinkingCode() {
        set("withLinkingCode", true);
        return (T) this;
    }

    /**
     * Sets the request to include the url to the identity's linking code qr image in the response.
     *
     * @return this request
     */
    default T withLinkingCodeQr() {
        set("withLinkingCodeQr", true);
        return (T) this;
    }

    /**
     * Sets the linking code qr image's size.
     *
     * @param val the size
     * @return    this request
     */
    default T linkingCodeQrSize(int val) {
        set("linkingCodeQrSize", val);
        return (T) this;
    }

    /**
     * Sets the request to include the wallet linked to the identity in the response.
     *
     * @return this request
     */
    default T withWallet() {
        set("withWallet", true);
        return (T) this;
    }

    /**
     * Sets the request to include the identity's timestamps in the response.
     *
     * @return this request
     */
    default T withIdentityTimestamps() {
        set("withIdentityTimestamps", true);
        return (T) this;
    }

}
