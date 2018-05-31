package com.enjin.enjincoin.sdk.client.service.platform;

import com.google.gson.JsonElement;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousPlatformService {

    Response<JsonElement> getPlatformSync() throws IOException;
}
