package com.enjin.enjincoin.sdk.client.service.platform;

import java.io.IOException;

import com.google.gson.JsonElement;
import retrofit2.Response;

public interface SynchronousPlatformService {

    Response<JsonElement> getPlatformSync() throws IOException;
}
