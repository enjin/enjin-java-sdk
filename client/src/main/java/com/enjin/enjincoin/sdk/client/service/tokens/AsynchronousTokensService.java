package com.enjin.enjincoin.sdk.client.service.tokens;

import com.google.gson.JsonElement;
import retrofit2.Callback;

public interface AsynchronousTokensService {

    void getAllTokensAsync(Callback<JsonElement> callback);

    void getTokensAsync(Integer id,
                           String creator,
                           String name,
                           Integer firstBlock,
                           Integer blockHeight,
                           Callback<JsonElement> callback);

}
