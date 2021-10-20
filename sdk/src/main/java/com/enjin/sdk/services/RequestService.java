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

package com.enjin.sdk.services;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Request;
import com.google.gson.JsonObject;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Used internally for transaction requests.
 */
public interface RequestService extends Delete {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    CompletableFuture<Response<GraphQLResponse<Request>>> getOne(@Path("schema") String schema,
                                                                 @Body JsonObject request);

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    CompletableFuture<Response<GraphQLResponse<List<Request>>>> getMany(@Path("schema") String schema,
                                                                        @Body JsonObject request);

}
