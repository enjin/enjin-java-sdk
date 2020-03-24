package com.enjin.sdk.models.token.event;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLVariableHolder;

public interface TokenEventFragment<T extends GraphQLRequest<T>> extends GraphQLVariableHolder<T> {

    default T withEventParams() {
        set("withEventParams", true);
        return (T) this;
    }

    default T withBlockNumber() {
        set("withBlockNumber", true);
        return (T) this;
    }

    default T withEventToken() {
        set("withEventToken", true);
        return (T) this;
    }

    default T withTokenEventTimestamps() {
        set("withTokenEventTimestamps", true);
        return (T) this;
    }

}
