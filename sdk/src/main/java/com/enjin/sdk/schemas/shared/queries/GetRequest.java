package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for getting a transaction on the platform.
 *
 * @see com.enjin.sdk.models.Request
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetRequest
        extends GraphQLRequest<GetRequest>
        implements TransactionFragmentArguments<GetRequest> {

    /**
     * Sole constructor.
     */
    public GetRequest() {
        super("enjin.sdk.shared.GetRequest");
    }

    /**
     * Sets the transaction ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetRequest id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the transaction hash ID.
     *
     * @param id the hash ID
     * @return this request for chaining
     */
    public GetRequest transactionId(String id) {
        return set("transactionId", id);
    }

}
