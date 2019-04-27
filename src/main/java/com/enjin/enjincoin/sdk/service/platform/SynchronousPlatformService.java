package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;

import java.io.IOException;

public interface SynchronousPlatformService {

    /**
     * @return
     *
     * @throws IOException
     */
    HttpResponse<GraphQLResponse<GetPlatformResult>> getPlatformSync() throws IOException;
}
