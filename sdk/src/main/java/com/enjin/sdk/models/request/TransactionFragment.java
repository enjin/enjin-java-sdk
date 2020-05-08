package com.enjin.sdk.models.request;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.token.event.TokenEventFragment;
import com.enjin.sdk.models.token.event.TokenEventType;
import com.enjin.sdk.services.request.RequestsService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see RequestsService
 * @param <T> the super type of the interface
 */
public interface TransactionFragment<T extends GraphQLRequest<T>>
        extends GraphQLVariableHolder<T>, TokenEventFragment<T> {

    /**
     * Sets the request to filter events in the response by the given id.
     *
     * @param val the id
     * @return    this request
     */
    default T eventsId(int val) {
        set("eventsId", val);
        return (T) this;
    }

    /**
     * Sets the request to filter events in the response by the given event type.
     *
     * @param val the event type
     * @return    this request
     */
    default T eventsType(TokenEventType val) {
        set("eventsType", val);
        return (T) this;
    }

    /**
     * Sets the request to include the token data of the transaction in the response.
     *
     * @return this request
     */
    default T withTokenData() {
        set("withTokenData", true);
        return (T) this;
    }

    /**
     * Sets the request to include the meta data in the response.
     *
     * @return this request
     */
    default T withMeta() {
        set("withMeta", true);
        return (T) this;
    }

    /**
     * Sets the request to include errors in the response.
     *
     * @return this request
     */
    default T withError() {
        set("withError", true);
        return (T) this;
    }

    /**
     * Sets the request to include the encoded data in the response.
     *
     * @return this request
     */
    default T withEncodedData() {
        set("withEncodedData", true);
        return (T) this;
    }

    /**
     * Sets the request to include the signed transaction strings in the response.
     *
     * @return this request
     */
    default T withSignedTxs() {
        set("withSignedTxs", true);
        return (T) this;
    }

    /**
     * Sets the request to include the nonce in the response.
     *
     * @return this request
     */
    default T withNonce() {
        set("withNonce", true);
        return (T) this;
    }

    /**
     * Sets the request to include the {@link TransactionState} in the response.
     *
     * @return this request
     */
    default T withState() {
        set("withState", true);
        return (T) this;
    }

    /**
     * Sets the request to include the receipt in the response.
     *
     * @return this request
     */
    default T withReceipt() {
        set("withReceipt", true);
        return (T) this;
    }

    /**
     * Sets the request to include the events in the response.
     *
     * @return this request
     */
    default T withEvents() {
        set("withEvents", true);
        return (T) this;
    }

    /**
     * Sets the request to include the timestamps in the response.
     *
     * @return this request
     */
    default T withRequestTimestamps() {
        set("withRequestTimestamps", true);
        return (T) this;
    }

}
