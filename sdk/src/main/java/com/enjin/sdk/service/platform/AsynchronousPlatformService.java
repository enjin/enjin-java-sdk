package com.enjin.sdk.service.platform;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.platform.PlatformDetails;

/**
 * Asynchronous methods for querying the platform.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousPlatformService {

    /**
     * Gets the platform details and settings.
     *
     * @param callback the callback.
     */
    void getPlatformAsync(HttpCallback<GraphQLResponse<PlatformDetails>> callback);
}
