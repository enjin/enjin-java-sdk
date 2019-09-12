package com.enjin.sdk.service.requests;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.requests.CreateRequest;
import com.enjin.sdk.model.service.requests.DeleteRequest;
import com.enjin.sdk.model.service.requests.GetRequests;
import com.enjin.sdk.model.service.requests.Transaction;
import com.enjin.sdk.model.service.requests.UpdateRequest;

public interface SynchronousRequestsService {

    /**
     * Gets app requests that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query) throws IOException;

    /**
     * Creates a new app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query) throws IOException;

    /**
     * Updates an app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query) throws IOException;

    HttpResponse<GraphQLResponse<Transaction>> deleteRequestSync(DeleteRequest query) throws IOException;

}
