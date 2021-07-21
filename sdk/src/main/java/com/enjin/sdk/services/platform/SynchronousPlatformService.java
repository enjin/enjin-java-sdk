package com.enjin.sdk.services.platform;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.platform.GasPrices;
import com.enjin.sdk.models.platform.GetGasPrice;
import com.enjin.sdk.models.platform.GetPlatform;
import com.enjin.sdk.models.platform.PlatformDetails;

/**
 * Synchronous methods for querying the platform.
 */
public interface SynchronousPlatformService {

    /**
     * Gets the platform details and settings.
     *
     * @param query the query.
     * @return      the response.
     */
    HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync(GetPlatform query);

    /**
     * Gets the latest gas prices.
     *
     * @param query the query.
     * @return      the response
     */
    HttpResponse<GraphQLResponse<GasPrices>> getGasPrice(GetGasPrice query);
}
