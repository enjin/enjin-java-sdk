package com.enjin.enjincoin.sdk.service.requests.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.DeleteRequest;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.Transaction;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;

import retrofit2.Retrofit;

public class RequestsServiceImpl extends GraphQLServiceBase implements RequestsService {

    private final RequestsRetrofitService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getRequestsAsync(GetRequests query,
                                 HttpCallback<GraphQLResponse<List<Transaction>>> callback) {
        enqueueGraphQLCall(this.service.getRequests(query), callback);
    }

    @Override
    public void createRequestAsync(CreateRequest query,
                                   HttpCallback<GraphQLResponse<Transaction>> callback) {
        enqueueGraphQLCall(this.service.createRequest(query), callback);
    }

    @Override
    public void updateRequestAsync(UpdateRequest query,
                                   HttpCallback<GraphQLResponse<Transaction>> callback) {
        enqueueGraphQLCall(this.service.updateRequest(query), callback);
    }

    @Override
    public void deleteRequestAsync(DeleteRequest query, HttpCallback<GraphQLResponse<Transaction>> callback) {
        enqueueGraphQLCall(this.service.deleteRequest(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query) throws IOException {
        return executeGraphQLCall(this.service.getRequests(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query) throws IOException {
        return executeGraphQLCall(this.service.createRequest(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query) throws IOException {
        return executeGraphQLCall(this.service.updateRequest(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> deleteRequestSync(DeleteRequest query) throws IOException {
        return executeGraphQLCall(this.service.deleteRequest(query));
    }

}
