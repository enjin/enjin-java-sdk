package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class CompleteTrade
        extends GraphQLRequest<CompleteTrade>
        implements TransactionRequestArguments<CompleteTrade> {

    /**
     * TODO
     */
    public CompleteTrade() {
        super("enjin.sdk.shared.CompleteTrade");
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public CompleteTrade tradeId(String id) {
        return set("tradeId", id);
    }

}
