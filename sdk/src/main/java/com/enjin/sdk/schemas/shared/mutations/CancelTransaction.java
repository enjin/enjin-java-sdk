package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for canceling a transaction on the platform.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class CancelTransaction extends GraphQLRequest<CancelTransaction> {

    /**
     * Sole constructor.
     */
    public CancelTransaction() {
        super("enjin.sdk.shared.CancelTransaction");
    }

    /**
     * Sets the ID of the transaction to cancel.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public CancelTransaction id(Integer id) {
        return set("id", id);
    }

}
