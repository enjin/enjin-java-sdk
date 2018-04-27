package com.enjin.enjincoin.sdk.client.service.platform;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import com.enjin.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Response;

public interface SynchronousPlatformService {

    Response<PlatformResponseBody> getPlatformSync() throws IOException;
}
