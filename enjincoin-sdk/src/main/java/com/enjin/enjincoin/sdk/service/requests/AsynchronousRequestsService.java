package com.enjin.enjincoin.sdk.service.requests;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequest;
import com.enjin.enjincoin.sdk.model.service.requests.DeleteRequest;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequests;
import com.enjin.enjincoin.sdk.model.service.requests.Transaction;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequest;

/**
 * Asynchronous methods for querying and mutating app requests.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousRequestsService {

    /**
     * Gets app requests that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getRequestsAsync(GetRequests query,
                          HttpCallback<GraphQLResponse<List<Transaction>>> callback);

    /**
     * Creates a new app request.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createRequestAsync(CreateRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

    /**
     * Updates an app request.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void updateRequestAsync(UpdateRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

    void deleteRequestAsync(DeleteRequest query,
                            HttpCallback<GraphQLResponse<Transaction>> callback);

}
