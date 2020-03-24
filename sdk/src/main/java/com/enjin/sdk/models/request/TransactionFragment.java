package com.enjin.sdk.models.request;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.token.event.TokenEventFragment;
import com.enjin.sdk.models.token.event.TokenEventType;

public interface TransactionFragment<T extends GraphQLRequest<T>>
        extends GraphQLVariableHolder<T>, TokenEventFragment<T> {

    default T eventsId(int val) {
        set("eventsId", val);
        return (T) this;
    }

    default T eventsType(TokenEventType val) {
        set("eventsType", val);
        return (T) this;
    }

    default T withTokenData() {
        set("withTokenData", true);
        return (T) this;
    }

    default T withMeta() {
        set("withMeta", true);
        return (T) this;
    }

    default T withError() {
        set("withError", true);
        return (T) this;
    }

    default T withEncodedData() {
        set("withEncodedData", true);
        return (T) this;
    }

    default T withSignedTxs() {
        set("withSignedTxs", true);
        return (T) this;
    }

    default T withNonce() {
        set("withNonce", true);
        return (T) this;
    }

    default T withState() {
        set("withState", true);
        return (T) this;
    }

    default T withReceipt() {
        set("withReceipt", true);
        return (T) this;
    }

    default T withEvents() {
        set("withEvents", true);
        return (T) this;
    }

    default T withRequestTimestamps() {
        set("withRequestTimestamps", true);
        return (T) this;
    }

}
