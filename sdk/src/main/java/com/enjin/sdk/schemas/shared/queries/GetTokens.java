package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TokenFilter;
import com.enjin.sdk.models.TokenSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.TokenFragmentArguments;

/**
 * Request for getting tokens on the platform.
 *
 * @see com.enjin.sdk.models.Token
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class GetTokens
        extends GraphQLRequest<GetTokens>
        implements TokenFragmentArguments<GetTokens>,
        PaginationArguments<GetTokens> {

    /**
     * Sole constructor.
     */
    public GetTokens() {
        super("enjin.sdk.shared.GetTokens");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetTokens filter(TokenFilter filter) {
        return set("filter", filter);
    }

    /**
     * Sets the request to sort the results by the specified options.
     *
     * @param sort the sort options
     * @return this request for chaining
     */
    public GetTokens sort(TokenSort sort) {
        return set("sort", sort);
    }

}
