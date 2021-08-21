package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for completing a trade between two wallets.
 *
 * @see CreateTrade
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class CompleteTrade
        extends GraphQLRequest<CompleteTrade>
        implements ProjectTransactionRequestArguments<CompleteTrade> {

    /**
     * Sole constructor.
     */
    public CompleteTrade() {
        super("enjin.sdk.project.CompleteTrade");
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
