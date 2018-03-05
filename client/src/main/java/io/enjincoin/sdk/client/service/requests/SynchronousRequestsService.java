package io.enjincoin.sdk.client.service.requests;

import java.io.IOException;

import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
import retrofit2.Response;

public interface SynchronousRequestsService {

    Response<RequestResponseBody[]> getRequestsSync() throws IOException;

    Response<RequestResponseBody> getRequestSync(long requestId) throws IOException;

    Response<CreateRequestResponseBody> createRequestSync(CreateRequestRequestBody createRequestRequestVO) throws IOException;

    Response<UpdateRequestResponseBody> updateRequestSync(long requestId, UpdateRequestRequestBody updateRequestRequest) throws IOException;

    Response<Boolean> deleteRequestSync(long requestId) throws IOException;

    Response<Boolean> executeRequestSync(long requestId, ExecuteRequestRequestBody executeRequestRequest) throws IOException;

    Response<Boolean> cancelRequestSync(long requestId) throws IOException;
}
