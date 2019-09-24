package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;

import java.io.IOException;

public interface SynchronousPlatformService {

    /**
     * Gets the platform details and settings.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync() throws IOException;
}
