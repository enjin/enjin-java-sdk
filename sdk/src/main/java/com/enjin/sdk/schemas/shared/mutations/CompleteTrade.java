package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for completing a trade between two wallets.
 *
 * @see CreateTrade
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class CompleteTrade
        extends GraphQLRequest<CompleteTrade>
        implements TransactionRequestArguments<CompleteTrade> {

    /**
     * Sole constructor.
     */
    public CompleteTrade() {
        super("enjin.sdk.shared.CompleteTrade");
    }

    /**
     * Sets the trade ID.
     *
     * @param id the ID.
     * @return this request for chaining
     */
    public CompleteTrade tradeId(String id) {
        return set("tradeId", id);
    }

}
