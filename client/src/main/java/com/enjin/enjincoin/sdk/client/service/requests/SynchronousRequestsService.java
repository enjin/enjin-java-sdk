package com.enjin.enjincoin.sdk.client.service.requests;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.service.requests.vo.*;
import com.enjin.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import com.enjin.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import com.enjin.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import com.enjin.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import com.enjin.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import com.enjin.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
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
