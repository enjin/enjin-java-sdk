package com.enjin.sdk.services.request.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.request.CreateRequest;
import com.enjin.sdk.models.request.DeleteRequest;
import com.enjin.sdk.models.request.GetRequests;
import com.enjin.sdk.models.request.Transaction;
import com.enjin.sdk.models.request.UpdateRequest;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.request.RequestsService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link RequestsService}.
 *
 * @see RequestsService
 */
public class RequestsServiceImpl extends GraphQLServiceBase implements RequestsService {

    private final RequestsRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit the retrofit adapter
     */
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
    public HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query) {
        return executeGraphQLCall(this.service.getRequests(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query) {
        return executeGraphQLCall(this.service.createRequest(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query) {
        return executeGraphQLCall(this.service.updateRequest(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Transaction>> deleteRequestSync(DeleteRequest query) {
        return executeGraphQLCall(this.service.deleteRequest(query));
    }

}
