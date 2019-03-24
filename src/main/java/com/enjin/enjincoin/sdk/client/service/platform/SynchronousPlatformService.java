package com.enjin.enjincoin.sdk.client.service.platform;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.platform.vo.data.PlatformData;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousPlatformService {

    /**
     *
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<PlatformData>> getPlatformSync() throws IOException;
}
