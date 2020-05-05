package com.enjin.sdk.services.request;

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
     * Gets application requests that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<List<Transaction>>> getRequestsSync(GetRequests query);

    /**
     * Creates a new application request.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Transaction>> createRequestSync(CreateRequest query);

    /**
     * Updates an application request.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Transaction>> updateRequestSync(UpdateRequest query);

    /**
     * Deletes an application request.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Transaction>> deleteRequestSync(DeleteRequest query);

}
