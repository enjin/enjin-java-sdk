package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateRequest;
import com.enjin.enjincoin.sdk.model.query.GetRequests;
import com.enjin.enjincoin.sdk.model.query.UpdateRequest;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;

public interface AsynchronousRequestsService {

    /**
     * @param callback
     */
    void getAllRequestsAsync(Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param query
     * @param callback
     */
    void getRequestsAsync(GetRequests query,
                          Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param query
     * @param callback
     */
    void createRequestAsync(CreateRequest query,
                            Callback<GraphQLResponse<CreateRequestData>> callback);

    /**
     * @param query
     * @param callback
     */
    void updateRequestAsync(UpdateRequest query,
                            Callback<GraphQLResponse<UpdateRequestData>> callback);

}
