package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.http.HttpResponse;
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
     * Gets all app requests.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetRequestsResult>> getAllRequestsSync() throws IOException;

    /**
     * Gets app requests that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetRequestsResult>> getRequestsSync(GetRequests query) throws IOException;

    /**
     * Creates a new app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<CreateRequestResult>> createRequestSync(CreateRequest query) throws IOException;

    /**
     * Updates an app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<UpdateRequestResult>> updateRequestSync(UpdateRequest query) throws IOException;

}
