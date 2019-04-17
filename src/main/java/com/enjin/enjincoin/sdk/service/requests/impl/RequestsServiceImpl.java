package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.util.concurrent.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class RequestsServiceImpl extends ServiceBase implements RequestsService {

    private RequestsRetrofitService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getAllRequestsAsync(Callback<GraphQLResponse<GetRequestsResult>> callback) {
        enqueue(getGetAllRequestsCall(), callback);
    }

    @Override
    public void getRequestsAsync(GetRequests query,
                                 Callback<GraphQLResponse<GetRequestsResult>> callback) {
        enqueue(getGetRequestsCall(query), callback);
    }

    @Override
    public void createRequestAsync(CreateRequest query,
                                   Callback<GraphQLResponse<CreateRequestResult>> callback) {
        enqueue(getCreateRequestCall(query), callback);
    }

    @Override
    public void updateRequestAsync(UpdateRequest query,
                                   Callback<GraphQLResponse<UpdateRequestResult>> callback) {
        enqueue(getUpdateRequestCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<GetRequestsResult>> getAllRequestsSync() throws IOException {
        return execute(getGetAllRequestsCall());
    }

    @Override
    public Response<GraphQLResponse<GetRequestsResult>> getRequestsSync(GetRequests query) throws IOException {
        return execute(getGetRequestsCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateRequestResult>> createRequestSync(CreateRequest query) throws IOException {
        return execute(getCreateRequestCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateRequestResult>> updateRequestSync(UpdateRequest query) throws IOException {
        return execute(getUpdateRequestCall(query));
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
