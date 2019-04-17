package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;
import com.enjin.enjincoin.sdk.http.Callback;

public interface AsynchronousRequestsService {

    /**
     * @param callback
     */
    void getAllRequestsAsync(Callback<GraphQLResponse<GetRequestsResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void getRequestsAsync(GetRequests query,
                          Callback<GraphQLResponse<GetRequestsResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void createRequestAsync(CreateRequest query,
                            Callback<GraphQLResponse<CreateRequestResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateRequestAsync(UpdateRequest query,
                            Callback<GraphQLResponse<UpdateRequestResult>> callback);

}
