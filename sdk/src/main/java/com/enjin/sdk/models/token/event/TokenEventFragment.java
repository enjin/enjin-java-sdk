package com.enjin.sdk.models.token.event;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.services.token.TokensService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see TokensService
 * @param <T> the super type of the interface
 */
public interface TokenEventFragment<T extends GraphQLRequest<T>> extends GraphQLVariableHolder<T> {

    /**
     * Sets the request to include the event parameters in the response.
     *
     * @return this request
     */
    default T withEventParams() {
        set("withEventParams", true);
        return (T) this;
    }

    /**
     * Sets the request to include the block number the event occurred in the response.
     *
     * @return this request
     */
    default T withBlockNumber() {
        set("withBlockNumber", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token the event belongs to in the response.
     *
     * @return this request
     */
    default T withEventToken() {
        set("withEventToken", true);
        return (T) this;
    }

    /**
     * Sets the request to include the event's timestamps in the response.
     *
     * @return this request
     */
    default T withTokenEventTimestamps() {
        set("withTokenEventTimestamps", true);
        return (T) this;
    }

}
