/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.http;

import java.io.IOException;

import com.enjin.sdk.schemas.BaseSchema;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A interceptor class for the Trusted Platform.
 */
public class TrustedPlatformInterceptor implements Interceptor {

    /**
     * The authorization key.
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * The user-agent key.
     */
    public static final String USER_AGENT = "User-Agent";

    /**
     * The user-agent value key.
     */
    public static final String USER_AGENT_VAL = "Enjin Java SDK v%s";

    /**
     * -- Setter --
     * @param token the new access token
     */
    @Setter
    private String token;

    /**
     * Rewrites calls to the Trusted Platform.
     *
     * @param chain the chain
     * @return the response
     * @throws IOException if the chain fails to proceed
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.header(USER_AGENT, String.format(USER_AGENT_VAL, BaseSchema.version()));

        if (isAuthenticated()) {
            builder.header(AUTHORIZATION, String.format("Bearer %s", token));
        }

        return chain.proceed(builder.build());
    }

    /**
     * Determines if the SDK is authenticated.
     *
     * @return true if authenticated, false otherwise
     */
    public boolean isAuthenticated() {
        return !(token == null || token.isEmpty());
    }

}
