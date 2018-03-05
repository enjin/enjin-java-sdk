package io.enjincoin.sdk.client.service.requests;

import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
import retrofit2.Callback;

public interface AsynchronousRequestsService {

    void getRequestsAsync(Callback<RequestResponseBody[]> callback);

    void getRequestAsync(long requestId, Callback<RequestResponseBody> callback);

    void createRequestAsync(CreateRequestRequestBody createRequestRequestVO, Callback<CreateRequestResponseBody> callback);

    void updateRequestAsync(long requestId, UpdateRequestRequestBody updateRequestRequest, Callback<UpdateRequestResponseBody> callback);

    void deleteRequestAsync(long requestId, Callback<Boolean> callback);

    void executeRequestAsync(long requestId, ExecuteRequestRequestBody executeRequestRequest, Callback<Boolean> callback);

    void cancelRequestAsync(long requestId, Callback<Boolean> callback);
}
