package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateRequest;
import com.enjin.enjincoin.sdk.model.query.GetRequests;
import com.enjin.enjincoin.sdk.model.query.UpdateRequest;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;

import java.io.IOException;

public interface SynchronousRequestsService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<RequestsData>> getAllRequestsSync() throws IOException;

    /**
     * @param query
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<RequestsData>> getRequestsSync(GetRequests query) throws IOException;

    /**
     * @param query
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<CreateRequestData>> createRequestSync(CreateRequest query) throws IOException;

    /**
     * @param query
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateRequestData>> updateRequestSync(UpdateRequest query) throws IOException;

}
