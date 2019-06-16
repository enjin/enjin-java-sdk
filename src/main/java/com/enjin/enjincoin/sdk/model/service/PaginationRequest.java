package com.enjin.enjincoin.sdk.model.service;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

public class PaginationRequest<T extends GraphQLRequest<T>> extends GraphQLRequest<T> {

    /**
     * Whether the request should be paginated.
     *
     * @param pagination the pagination input.
     *
     * @return the builder.
     */
    public T withPagination(PaginationInput pagination) {
        withParameter("pagination", pagination);
        return (T) this;
    }

}
