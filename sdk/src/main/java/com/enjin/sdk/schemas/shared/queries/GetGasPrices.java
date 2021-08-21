package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting the latest gas prices.
 *
 * @see com.enjin.sdk.models.GasPrices
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetGasPrices extends GraphQLRequest<GetGasPrices> {

    /**
     * Sole constructor.
     */
    public GetGasPrices() {
        super("enjin.sdk.shared.GetGasPrices");
    }

}
