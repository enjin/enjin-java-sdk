package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;
import com.enjin.enjincoin.sdk.http.Callback;

public interface AsynchronousPlatformService {

    /**
     * @param callback
     */
    void getPlatformAsync(Callback<GraphQLResponse<GetPlatformResult>> callback);
}
