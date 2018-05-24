package com.enjin.enjincoin.sdk.client.service.platform;

import com.google.gson.JsonElement;
import retrofit2.Callback;

public interface AsynchronousPlatformService {

    void getPlatformAsync(Callback<JsonElement> callback);
}
