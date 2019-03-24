package com.enjin.enjincoin.sdk.client.service.platform;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.platform.vo.data.PlatformData;
import retrofit2.Callback;

public interface AsynchronousPlatformService {

    /**
     * @param callback
     */
    void getPlatformAsync(Callback<GraphQLResponse<PlatformData>> callback);
}
