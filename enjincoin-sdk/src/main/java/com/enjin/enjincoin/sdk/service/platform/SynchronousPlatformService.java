package com.enjin.enjincoin.sdk.service.platform;

import java.io.IOException;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;

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
