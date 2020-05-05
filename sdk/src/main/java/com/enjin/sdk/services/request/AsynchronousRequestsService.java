package com.enjin.sdk.services.request;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.request.CreateRequest;
import com.enjin.sdk.models.request.DeleteRequest;
import com.enjin.sdk.models.request.GetRequests;
import com.enjin.sdk.models.request.Transaction;
import com.enjin.sdk.models.request.UpdateRequest;

/**
 * Asynchronous methods for querying and mutating application requests.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousRequestsService {

    /**
     * Gets application requests that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getRequestsAsync(GetRequests query,
                          HttpCallback<GraphQLResponse<List<Transaction>>> callback);

    /**
     * Creates a new application request.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createRequestAsync(CreateRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

    /**
     * Updates an application request.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void updateRequestAsync(UpdateRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

    /**
     * Deletes an application request.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void deleteRequestAsync(DeleteRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

}
