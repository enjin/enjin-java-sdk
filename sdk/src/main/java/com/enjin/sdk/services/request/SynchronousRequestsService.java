package com.enjin.sdk.services.request;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.request.CreateRequest;
import com.enjin.sdk.models.request.DeleteRequest;
import com.enjin.sdk.models.request.GetRequests;
import com.enjin.sdk.models.request.Transaction;
import com.enjin.sdk.models.request.UpdateRequest;

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
    HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query);

    /**
     * Creates a new app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query);

    /**
     * Updates an app request.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query);

    HttpResponse<GraphQLResponse<Transaction>> deleteRequestSync(DeleteRequest query);

}
