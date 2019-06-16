package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.Transaction;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class RequestsServiceImpl extends GraphQLServiceBase implements RequestsService {

    private final RequestsRetrofitService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getRequestsAsync(GetRequests query,
                                 HttpCallback<GraphQLResponse<List<Transaction>>> callback) {
        enqueueGraphQLCall(getGetRequestsCall(query), callback);
    }

    @Override
    public void createRequestAsync(CreateRequest query,
                                   HttpCallback<GraphQLResponse<Transaction>> callback) {
        enqueueGraphQLCall(getCreateRequestCall(query), callback);
    }

    @Override
    public void updateRequestAsync(UpdateRequest query,
                                   HttpCallback<GraphQLResponse<Transaction>> callback) {
        enqueueGraphQLCall(getUpdateRequestCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query) throws IOException {
        return executeGraphQLCall(getGetRequestsCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query) throws IOException {
        return executeGraphQLCall(getCreateRequestCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query) throws IOException {
        return executeGraphQLCall(getUpdateRequestCall(query));
    }

    private Call<GraphQLResponse<List<Transaction>>> getGetRequestsCall(GetRequests query) {
        return this.service.getRequests(query);
    }

    private Call<GraphQLResponse<Transaction>> getCreateRequestCall(CreateRequest query) {
        return this.service.createRequest(query);
    }

    private Call<GraphQLResponse<Transaction>> getUpdateRequestCall(UpdateRequest query) {
        return this.service.updateRequest(query);
    }

}
