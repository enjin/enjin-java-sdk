package com.enjin.enjincoin.sdk.client.service.platform;

import com.enjin.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import com.enjin.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Callback;

public interface AsynchronousPlatformService {

    void getPlatformAsync(Callback<PlatformResponseBody> callback);
}
