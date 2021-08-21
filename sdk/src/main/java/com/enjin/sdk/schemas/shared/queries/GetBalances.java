package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.BalanceFilter;
import com.enjin.sdk.schemas.shared.arguments.BalanceFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;

/**
 * Request for getting balances on the platform.
 *
 * @see com.enjin.sdk.models.Balance
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetBalances
        extends GraphQLRequest<GetBalances>
        implements BalanceFragmentArguments<GetBalances>,
        PaginationArguments<GetBalances> {

    /**
     * Sole constructor.
     */
    public GetBalances() {
        super("enjin.sdk.shared.GetBalances");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetBalances filter(BalanceFilter filter) {
        return set("filter", filter);
    }

}
