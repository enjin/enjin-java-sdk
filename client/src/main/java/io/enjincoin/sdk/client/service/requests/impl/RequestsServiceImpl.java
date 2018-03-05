package io.enjincoin.sdk.client.service.requests.impl;

import java.io.IOException;

import io.enjincoin.sdk.client.service.requests.RequestsService;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RequestsServiceImpl implements RequestsService{

    private RetrofitRequestsService service;

    public RequestsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitRequestsService.class);
    }

    @Override
    public void getRequestsAsync(Callback<RequestResponseBody[]> callback) {
        Call<RequestResponseBody[]> call = this.service.getRequests();
        call.enqueue(callback);
    }

    @Override
    public void getRequestAsync(long requestId, Callback<RequestResponseBody> callback) {
        Call<RequestResponseBody> call = this.service.getRequest(requestId);
        call.enqueue(callback);
    }

    @Override
    public void createRequestAsync(CreateRequestRequestBody createRequestRequestVO, Callback<CreateRequestResponseBody> callback) {
        Call<CreateRequestResponseBody> call = this.service.createRequest(createRequestRequestVO);
        call.enqueue(callback);
    }

    @Override
    public void updateRequestAsync(long requestId, UpdateRequestRequestBody updateRequestRequest, Callback<UpdateRequestResponseBody> callback) {
        Call<UpdateRequestResponseBody> call = this.service.updateRequest(requestId, updateRequestRequest);
        call.enqueue(callback);
    }

    @Override
    public void deleteRequestAsync(long requestId, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.deleteRequest(requestId);
        call.enqueue(callback);
    }

    @Override
    public void executeRequestAsync(long requestId, ExecuteRequestRequestBody executeRequestRequest, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.executeRequest(requestId, executeRequestRequest);
        call.enqueue(callback);
    }

    @Override
    public void cancelRequestAsync(long requestId, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.cancelRequest(requestId);
        call.enqueue(callback);
    }

    @Override
    public Response<RequestResponseBody[]> getRequestsSync() throws IOException {
        Call<RequestResponseBody[]> call = this.service.getRequests();
        return call.execute();
    }

    @Override
    public Response<RequestResponseBody> getRequestSync(long requestId) throws IOException {
        Call<RequestResponseBody> call = this.service.getRequest(requestId);
        return call.execute();
    }

    @Override
    public Response<CreateRequestResponseBody> createRequestSync(CreateRequestRequestBody createRequestRequestVO) throws IOException {
        Call<CreateRequestResponseBody> call = this.service.createRequest(createRequestRequestVO);
        return call.execute();
    }

    @Override
    public Response<UpdateRequestResponseBody> updateRequestSync(long requestId, UpdateRequestRequestBody updateRequestRequest) throws IOException {
        Call<UpdateRequestResponseBody> call = this.service.updateRequest(requestId, updateRequestRequest);
        return call.execute();
    }

    @Override
    public Response<Boolean> deleteRequestSync(long requestId) throws IOException {
        Call<Boolean> call = this.service.deleteRequest(requestId);
        return call.execute();
    }

    @Override
    public Response<Boolean> executeRequestSync(long requestId, ExecuteRequestRequestBody executeRequestRequest) throws IOException {
        Call<Boolean> call = this.service.executeRequest(requestId, executeRequestRequest);
        return call.execute();
    }

    @Override
    public Response<Boolean> cancelRequestSync(long requestId) throws IOException {
        Call<Boolean> call = this.service.cancelRequest(requestId);
        return call.execute();
    }


}
