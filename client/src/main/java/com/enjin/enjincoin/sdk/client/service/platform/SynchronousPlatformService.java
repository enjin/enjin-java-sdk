package com.enjin.enjincoin.sdk.client.service.platform;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousPlatformService {

    Response<GraphQLResponse> getPlatformSync() throws IOException;
}
