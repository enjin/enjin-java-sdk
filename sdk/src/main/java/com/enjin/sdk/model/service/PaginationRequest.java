package com.enjin.sdk.model.service;

import com.enjin.sdk.graphql.GraphQLRequest;

public class PaginationRequest<T extends GraphQLRequest<T>> extends GraphQLRequest<T> {

    public static final int DEFAULT_LIMIT = 10;

    /**
     * Whether the request should be paginated.
     *
     * @param pagination the pagination input.
     *
     * @return the builder.
     */
    public T paginate(PaginationInput pagination) {
        withParameter("pagination", pagination);
        return (T) this;
    }

    public T paginate(int page, int limit) {
        return paginate(new PaginationInput(page, limit));
    }

    public T paginate(int page) {
        return paginate(page, DEFAULT_LIMIT);
    }

}
