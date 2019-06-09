package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;

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
