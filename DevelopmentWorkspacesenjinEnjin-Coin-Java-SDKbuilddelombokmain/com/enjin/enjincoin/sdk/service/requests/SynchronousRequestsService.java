package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.http.Result;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;

import java.io.IOException;

public interface SynchronousRequestsService {

    /**
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<GetRequestsResult>> getAllRequestsSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<GetRequestsResult>> getRequestsSync(GetRequests query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<CreateRequestResult>> createRequestSync(CreateRequest query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Result<GraphQLResponse<UpdateRequestResult>> updateRequestSync(UpdateRequest query) throws IOException;

}
