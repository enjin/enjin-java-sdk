package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;
import com.enjin.enjincoin.sdk.http.HttpCallback;

public interface AsynchronousRequestsService {

    /**
     * @param callback
     */
    void getAllRequestsAsync(HttpCallback<GraphQLResponse<GetRequestsResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void getRequestsAsync(GetRequests query,
                          HttpCallback<GraphQLResponse<GetRequestsResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void createRequestAsync(CreateRequest query,
                            HttpCallback<GraphQLResponse<CreateRequestResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateRequestAsync(UpdateRequest query,
                            HttpCallback<GraphQLResponse<UpdateRequestResult>> callback);

}
