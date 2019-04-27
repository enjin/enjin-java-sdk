package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;
import com.enjin.enjincoin.sdk.http.HttpCallback;

public interface AsynchronousPlatformService {

    /**
     * @param callback
     */
    void getPlatformAsync(HttpCallback<GraphQLResponse<GetPlatformResult>> callback);
}
