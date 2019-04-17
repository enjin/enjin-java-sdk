package com.enjin.enjincoin.sdk.service.auth;

import com.enjin.enjincoin.sdk.model.service.auth.AuthBody;
import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.enjincoin.sdk.serialization.Json;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthRetrofitService {

    /**
     * @param body
     *
     * @return
     */
    @POST("oauth/token")
    Call<AuthResult> auth(@Json @Body AuthBody body);

}
