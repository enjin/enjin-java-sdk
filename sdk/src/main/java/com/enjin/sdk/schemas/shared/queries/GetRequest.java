package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * TODO
 */
public class GetRequest
        extends GraphQLRequest<GetRequest>
        implements TransactionFragmentArguments<GetRequest> {

    /**
     * TODO
     */
    public GetRequest() {
        super("enjin.sdk.shared.GetRequest");
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public GetRequest id(int id) {
        return set("id", id);
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public GetRequest transactionId(String id) {
        return set("transactionId", id);
    }

}
