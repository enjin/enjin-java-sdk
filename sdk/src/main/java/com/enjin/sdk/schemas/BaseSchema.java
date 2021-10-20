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

package com.enjin.sdk.schemas;

import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;

import com.enjin.sdk.serialization.BigIntegerDeserializer;
import com.enjin.sdk.serialization.converter.GraphConverter;
import com.enjin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.sdk.utils.LoggerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Base class for schema with functionality to send GraphQL requests to the platform and process the responses.
 */
public class BaseSchema {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
            .enableComplexMapKeySerialization()
            .setLenient()
            .create();
    private static final MediaType JSON = MediaType.parse("application/json");

    /**
     * -- Getter --
     *
     * @return the logger provider
     */
    @Getter
    private final LoggerProvider loggerProvider;

    private final Retrofit retrofit;
    protected final TrustedPlatformMiddleware middleware;
    protected final String schema;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware     the middleware
     * @param schema         the schema
     * @param loggerProvider the logger provider
     */
    public BaseSchema(TrustedPlatformMiddleware middleware, String schema, LoggerProvider loggerProvider) {
        this.schema = schema;
        this.middleware = middleware;
        this.loggerProvider = loggerProvider;

        Gson gson = new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .create();
        Converter.Factory gsonFactory = GsonConverterFactory.create(gson);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.middleware.getBaseUrl())
                .client(this.middleware.getHttpClient())
                .addConverterFactory(GraphConverter.create(this.loggerProvider))
                .addConverterFactory(JsonStringConverter.create(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    /**
     * Creates the serialized request body to be sent to the platform.
     *
     * @param request the request
     * @param <T>     the type of the request
     *
     * @return the serialized request
     */
    protected <T extends GraphQLRequest<T>> JsonObject createRequestBody(GraphQLRequest<T> request) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("query", middleware.getQueryRegistry().get(request.getNamespace()));
        requestBody.add("variables", GSON.toJsonTree(request.getVariables()));
        return requestBody;
    }

    /**
     * Creates a retrofit service.
     *
     * @param service the service class
     * @param <T>     the type of the service
     *
     * @return the created service
     */
    protected <T> Object createService(@NotNull Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * Sends a request and returns a future containing the response.
     *
     * @param response the future containing the retrofit response
     * @param <T>      the type of the response
     *
     * @return the future for this operation
     */
    @SneakyThrows
    protected <T> CompletableFuture<GraphQLResponse<T>> sendRequest(CompletableFuture<Response<GraphQLResponse<T>>> response) {
        return response.thenApply(BaseSchema::createResult);
    }

    /**
     * Processes the retrofit response and returns the GraphQL response.
     *
     * @param response the retrofit response
     * @param <T>      the type of the response
     *
     * @return the GraphQL response
     */
    @SneakyThrows
    protected static <T> GraphQLResponse<T> createResult(Response<GraphQLResponse<T>> response) {
        if (response.isSuccessful() || response.body() != null)
            return response.body();

        ResponseBody errorBody = response.errorBody();
        if (errorBody != null && Objects.equals(errorBody.contentType(), JSON)) {
            TypeToken<GraphQLResponse<T>> token = new TypeToken<GraphQLResponse<T>>() {};
            String rawBody = errorBody.string();
            return (GraphQLResponse<T>) GSON.fromJson(rawBody, token.getRawType());
        }

        return null;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public static String version() {
        return "@version@";
    }

}
