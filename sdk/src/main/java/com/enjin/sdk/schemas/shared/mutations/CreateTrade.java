package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Trade;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

public class CreateTrade
        extends GraphQLRequest<CreateTrade>
        implements TransactionFragmentArguments<CreateTrade>,
        TransactionRequestArguments<CreateTrade> {

    public CreateTrade() {
        super("enjin.sdk.shared.CreateTrade");
    }

    public CreateTrade askingTokens(Trade... tokens) {
        return set("askingTokens", tokens);
    }

    public CreateTrade offeringTokens(Trade... tokens) {
        return set("offeringTokens", tokens);
    }

    /**
     *
     * @param recipientAddress
     * @return
     */
    public CreateTrade recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

}
