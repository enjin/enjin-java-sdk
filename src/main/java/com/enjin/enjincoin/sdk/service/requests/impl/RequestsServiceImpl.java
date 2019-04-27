package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class RequestsServiceImpl extends GraphQLServiceBase implements RequestsService {

    private RequestsRetrofitService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getAllRequestsAsync(HttpCallback<GraphQLResponse<GetRequestsResult>> callback) {
        enqueueGraphQLCall(getGetAllRequestsCall(), callback);
    }

    @Override
    public void getRequestsAsync(GetRequests query,
                                 HttpCallback<GraphQLResponse<GetRequestsResult>> callback) {
        enqueueGraphQLCall(getGetRequestsCall(query), callback);
    }

    @Override
    public void createRequestAsync(CreateRequest query,
                                   HttpCallback<GraphQLResponse<CreateRequestResult>> callback) {
        enqueueGraphQLCall(getCreateRequestCall(query), callback);
    }

    @Override
    public void updateRequestAsync(UpdateRequest query,
                                   HttpCallback<GraphQLResponse<UpdateRequestResult>> callback) {
        enqueueGraphQLCall(getUpdateRequestCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<GetRequestsResult>> getAllRequestsSync() throws IOException {
        return executeGraphQLCall(getGetAllRequestsCall());
    }

    @Override
    public HttpResponse<GraphQLResponse<GetRequestsResult>> getRequestsSync(GetRequests query) throws IOException {
        return executeGraphQLCall(getGetRequestsCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<CreateRequestResult>> createRequestSync(CreateRequest query) throws IOException {
        return executeGraphQLCall(getCreateRequestCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<UpdateRequestResult>> updateRequestSync(UpdateRequest query) throws IOException {
        return executeGraphQLCall(getUpdateRequestCall(query));
    }

    private Call<GraphQLResponse<GetRequestsResult>> getGetAllRequestsCall() {
        return this.service.getAllRequests(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<GetRequestsResult>> getGetRequestsCall(GetRequests query) {
        return this.service.getRequests(query);
    }

    private Call<GraphQLResponse<CreateRequestResult>> getCreateRequestCall(CreateRequest query) {
        return this.service.createRequest(query);
    }

    private Call<GraphQLResponse<UpdateRequestResult>> getUpdateRequestCall(UpdateRequest query) {
        return this.service.updateRequest(query);
    }

}
