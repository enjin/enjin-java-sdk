package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.identity.IdentityFragment;
import com.enjin.sdk.services.app.AppsService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see AppsService
 * @param <T> the super type of the interface
 */
public interface AppFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T>, IdentityFragment<T> {

    /**
     * Sets the request to include the application's secret in the response.
     *
     * @return this request
     */
    default T withSecret() {
        set("withSecret", true);
        return (T) this;
    }

    /**
     * Sets the request to include the application's linking code in the response.
     *
     * @return this request
     */
    default T withLinkingCode() {
        set("withLinkingCode", true);
        return (T) this;
    }

    /**
     * Sets the request to include the link to the application's linking code qr image in the response.
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
     * Sets the request to include the application's current user's identity in the response.
     *
     * @return this request
     */
    default T withCurrentUserIdentity() {
        set("withCurrentUserIdentity", true);
        return (T) this;
    }

    /**
     * Sets the request to include the application's owner in the response.
     *
     * @return this request
     */
    default T withOwner() {
        set("withOwner", true);
        return (T) this;
    }

    /**
     * Sets the request to include the number of tokens created for the application in the response.
     *
     * @return this request
     */
    default T withTokenCount() {
        set("withTokenCount", true);
        return (T) this;
    }

    /**
     * Sets the request to include the application's timestamps in the response.
     *
     * @return this request
     */
    default T withAppTimestamps() {
        set("withAppTimestamps", true);
        return (T) this;
    }

}
