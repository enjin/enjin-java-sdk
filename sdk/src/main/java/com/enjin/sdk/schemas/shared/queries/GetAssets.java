package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.AssetFilter;
import com.enjin.sdk.models.AssetSort;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.AssetFragmentArguments;

/**
 * Request for getting assets on the platform.
 *
 * @see com.enjin.sdk.models.Asset
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetAssets
        extends GraphQLRequest<GetAssets>
        implements AssetFragmentArguments<GetAssets>,
        PaginationArguments<GetAssets> {

    /**
     * Sole constructor.
     */
    public GetAssets() {
        super("enjin.sdk.shared.GetAssets");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetAssets filter(AssetFilter filter) {
        return set("filter", filter);
    }

    /**
     * Sets the request to sort the results by the specified options.
     *
     * @param sort the sort options
     * @return this request for chaining
     */
    public GetAssets sort(AssetSort sort) {
        return set("sort", sort);
    }

}
