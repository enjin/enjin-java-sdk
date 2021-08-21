package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for completing a trade between two wallets.
 *
 * @see CreateTrade
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class CompleteTrade
        extends GraphQLRequest<CompleteTrade>
        implements TransactionFragmentArguments<CompleteTrade> {

    /**
     * Sole constructor.
     */
    public CompleteTrade() {
        super("enjin.sdk.player.CompleteTrade");
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
