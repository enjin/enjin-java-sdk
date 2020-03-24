package com.enjin.sdk.services.platform;

import java.io.IOException;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.platform.GetPlatform;
import com.enjin.sdk.models.platform.PlatformDetails;

public interface SynchronousPlatformService {

    /**
     * Gets the platform details and settings.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync(GetPlatform query);
}
