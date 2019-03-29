package com.enjin.enjincoin.sdk.service.platform;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.platform.vo.data.PlatformData;

public interface AsynchronousPlatformService {

    /**
     * @param callback
     */
    void getPlatformAsync(Callback<GraphQLResponse<PlatformData>> callback);
}
