package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Transfers;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for sending one or more items in a single transaction.
 *
 * @see SendToken
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class AdvancedSendToken
        extends GraphQLRequest<AdvancedSendToken>
        implements TransactionRequestArguments<AdvancedSendToken> {

    /**
     * Sole constructor.
     */
    public AdvancedSendToken() {
        super("enjin.sdk.shared.AdvancedSendToken");
    }

    /**
     * Sets the different transfers to perform.
     *
     * @param transfers the transfers
     * @return this request for chaining
     */
    public AdvancedSendToken transfers(Transfers... transfers) {
        return set("transfers", transfers);
    }

    /**
     * Sets the data to forward with the transaction.
     *
     * @param data the data
     * @return this request for chaining
     */
    public AdvancedSendToken data(String data) {
        return set("data", data);
    }

}
