package com.enjin.enjincoin.sdk.client.service.platform;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Callback;

public interface AsynchronousPlatformService {

    void getPlatformAsync(Callback<GraphQLResponse> callback);
}
