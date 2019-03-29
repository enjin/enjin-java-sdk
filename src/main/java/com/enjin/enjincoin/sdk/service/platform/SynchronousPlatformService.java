package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.platform.vo.data.PlatformData;

import java.io.IOException;

public interface SynchronousPlatformService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<PlatformData>> getPlatformSync() throws IOException;
}
