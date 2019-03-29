package com.enjin.enjincoin.sdk.service.auth;

import com.enjin.enjincoin.sdk.annotation.Json;
import com.enjin.enjincoin.sdk.service.auth.vo.AuthBody;
import com.enjin.enjincoin.sdk.service.auth.vo.AuthData;
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
    Call<AuthData> auth(@Json @Body AuthBody body);

}
