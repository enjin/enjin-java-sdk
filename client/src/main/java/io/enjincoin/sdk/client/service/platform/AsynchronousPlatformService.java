package io.enjincoin.sdk.client.service.platform;

import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Callback;

public interface AsynchronousPlatformService {

    void getPlatformAsync(Callback<PlatformResponseBody> callback);
}
