package com.enjin.enjincoin.sdk.service.roles.impl;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.roles.Role;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RolesRetrofitService {

    @POST("graphql")
    @GraphQuery("GetRoles")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<List<Role>>> getRoles(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> createRole(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> deleteRole(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateRole")
    @Headers("Content-Type: Rolelication/json")
    Call<GraphQLResponse<Role>> updateRole(@Body GraphQLRequest request);

}
