package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TransactionFilter;
import com.enjin.sdk.models.TransactionSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * TODO
 */
public class GetRequests
        extends GraphQLRequest<GetRequests>
        implements TransactionFragmentArguments<GetRequests>,
        PaginationArguments<GetRequests> {

    /**
     * TODO
     */
    public GetRequests() {
        super("enjin.sdk.shared.GetRequests");
    }

    /**
     * TODO
     * @param filter
     * @return
     */
    public GetRequests filter(TransactionFilter filter) {
        return set("filter", filter);
    }

    /**
     * TODO
     * @param sort
     * @return
     */
    public GetRequests sort(TransactionSort sort) {
        return set("sort", sort);
    }

}
