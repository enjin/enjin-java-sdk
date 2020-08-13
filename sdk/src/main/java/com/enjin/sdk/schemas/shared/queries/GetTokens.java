package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TokenFilter;
import com.enjin.sdk.models.TokenSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.TokenFragmentArguments;

/**
 * TODO
 */
public class GetTokens
        extends GraphQLRequest<GetTokens>
        implements TokenFragmentArguments<GetTokens>,
        PaginationArguments<GetTokens> {

    /**
     * TODO
     */
    public GetTokens() {
        super("enjin.sdk.shared.GetTokens");
    }

    /**
     * TODO
     * @param filter
     * @return
     */
    public GetTokens filter(TokenFilter filter) {
        return set("filter", filter);
    }

    /**
     * TODO
     * @param sort
     * @return
     */
    public GetTokens sort(TokenSort sort) {
        return set("sort", sort);
    }

}
