package com.enjin.enjincoin.sdk.client.service.tokens;

import com.google.gson.JsonElement;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    Response<JsonElement> getAllTokensSync() throws IOException;

    Response<JsonElement> getTokensSync(Integer id,
                                        String creator,
                                        String name,
                                        Integer firstBlock,
                                        Integer blockHeight) throws IOException;

}
