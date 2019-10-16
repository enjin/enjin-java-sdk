package com.enjin.sdk.service.roles.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.roles.Role;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RolesRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetRoles")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<List<Role>>> getRoles(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> createRole(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> deleteRole(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> updateRole(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
