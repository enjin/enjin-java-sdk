package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateRequest;
import com.enjin.enjincoin.sdk.model.query.GetRequests;
import com.enjin.enjincoin.sdk.model.query.UpdateRequest;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class RequestsServiceImpl extends ServiceBase implements RequestsService {

    private RequestsRetrofitService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getAllRequestsAsync(Callback<GraphQLResponse<RequestsData>> callback) {
        enqueue(getGetAllRequestsCall(), callback);
    }

    @Override
    public void getRequestsAsync(GetRequests query,
                                 Callback<GraphQLResponse<RequestsData>> callback) {
        enqueue(getGetRequestsCall(query), callback);
    }

    @Override
    public void createRequestAsync(CreateRequest query,
                                   Callback<GraphQLResponse<CreateRequestData>> callback) {
        enqueue(getCreateRequestCall(query), callback);
    }

    @Override
    public void updateRequestAsync(UpdateRequest query,
                                   Callback<GraphQLResponse<UpdateRequestData>> callback) {
        enqueue(getUpdateRequestCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getAllRequestsSync() throws IOException {
        return execute(getGetAllRequestsCall());
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getRequestsSync(GetRequests query) throws IOException {
        return execute(getGetRequestsCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateRequestData>> createRequestSync(CreateRequest query) throws IOException {
        return execute(getCreateRequestCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateRequestData>> updateRequestSync(UpdateRequest query) throws IOException {
        return execute(getUpdateRequestCall(query));
    }

    private Call<GraphQLResponse<RequestsData>> getGetAllRequestsCall() {
        return this.service.getAllRequests(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<RequestsData>> getGetRequestsCall(GetRequests query) {
        return this.service.getRequests(query);
    }

    private Call<GraphQLResponse<CreateRequestData>> getCreateRequestCall(CreateRequest query) {
        return this.service.createRequest(query);
    }

    private Call<GraphQLResponse<UpdateRequestData>> getUpdateRequestCall(UpdateRequest query) {
        return this.service.updateRequest(query);
    }

}
