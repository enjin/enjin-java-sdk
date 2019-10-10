package com.enjin.sdk.service.auth;

import com.enjin.sdk.model.service.auth.AuthBody;
import com.enjin.sdk.model.service.auth.AuthResult;
import com.enjin.sdk.serialization.Json;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Authenticates the client with the app secret.
 *
 * @author Evan Lindsay
 */
public interface AuthRetrofitService {

    /**
     * Authenticate the client.
     *
     * @param body the authentication body.
     *
     * @return a call instance.
     */
    @POST("oauth/token")
    Call<AuthResult> auth(@Json @Body AuthBody body);

}
