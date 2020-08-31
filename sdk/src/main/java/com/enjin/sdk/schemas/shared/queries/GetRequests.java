package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TransactionFilter;
import com.enjin.sdk.models.TransactionSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for getting transactions on the platform.
 *
 * @see com.enjin.sdk.models.Request
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class GetRequests
        extends GraphQLRequest<GetRequests>
        implements TransactionFragmentArguments<GetRequests>,
        PaginationArguments<GetRequests> {

    /**
     * Sole constructor.
     */
    public GetRequests() {
        super("enjin.sdk.shared.GetRequests");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetRequests filter(TransactionFilter filter) {
        return set("filter", filter);
    }

    /**
     * Sets the request to sort the results by the specified options.
     *
     * @param sort the sort options
     * @return this request for chaining
     */
    public GetRequests sort(TransactionSort sort) {
        return set("sort", sort);
    }

}
