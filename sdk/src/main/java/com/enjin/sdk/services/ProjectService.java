package com.enjin.sdk.services;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Project;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Used internally for project requests.
 */
public interface ProjectService extends Auth, Delete {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Project>> getOne(@Path("schema") String schema,
                                          @Body JsonObject request);

}
