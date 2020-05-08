package com.enjin.sdk.models;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * A class used to include information in a builder for pagination requests from the Trusted Platform.
 *
 * @param <T> the super type of the class
 */
public class PaginationRequest<T extends GraphQLRequest<T>> extends GraphQLRequest<T> {

    /**
     * The default number of results to return per page.
     */
    public static final int DEFAULT_LIMIT = 10;

    /**
     * Whether the request should be paginated.
     *
     * @param pagination the pagination input.
     *
     * @return the builder.
     */
    public T paginate(PaginationInput pagination) {
        set("pagination", pagination);
        return (T) this;
    }

    /**
     * Sets whether the request should be paginated and sets the pagination input.
     *
     * @param page  the page number for the pagination input.
     * @param limit the results limit per page for the pagination input.
     * @return      the builder.
     */
    public T paginate(int page, int limit) {
        return paginate(new PaginationInput(page, limit));
    }

    /**
     * Sets whether the request should be paginated and sets the pagination input's starting page.
     *
     * @param page the page number for the pagination input.
     * @return     the builder.
     */
    public T paginate(int page) {
        return paginate(page, DEFAULT_LIMIT);
    }

}
