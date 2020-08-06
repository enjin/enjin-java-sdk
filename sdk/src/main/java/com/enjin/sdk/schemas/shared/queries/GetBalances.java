package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.BalanceFilter;
import com.enjin.sdk.schemas.shared.arguments.BalanceFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;

/**
 * TODO
 */
public class GetBalances
        extends GraphQLRequest<GetBalances>
        implements BalanceFragmentArguments<GetBalances>,
        PaginationArguments<GetBalances> {

    /**
     * TODO
     */
    public GetBalances() {
        super("enjin.sdk.shared.GetBalances");
    }

    /**
     * TODO
     * @param filter
     * @return
     */
    public GetBalances filter(BalanceFilter filter) {
        return set("filter", filter);
    }

}
