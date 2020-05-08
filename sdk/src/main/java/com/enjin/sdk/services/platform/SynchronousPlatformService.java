package com.enjin.sdk.services.platform;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.platform.GetPlatform;
import com.enjin.sdk.models.platform.PlatformDetails;

/**
 *
 */
public interface SynchronousPlatformService {

    /**
     * Gets the platform details and settings.
     *
     * @param query the query.
     * @return      the response.
     */
    HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync(GetPlatform query);
}
