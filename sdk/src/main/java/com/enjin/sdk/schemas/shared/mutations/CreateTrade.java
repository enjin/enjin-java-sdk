package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Trade;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for creating a trade between two wallets.
 *
 * @see CompleteTrade
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class CreateTrade
        extends GraphQLRequest<CreateTrade>
        implements TransactionRequestArguments<CreateTrade> {

    /**
     * Sole constructor.
     */
    public CreateTrade() {
        super("enjin.sdk.shared.CreateTrade");
    }

    /**
     * Sets the tokens (items) the sender is asking for.
     *
     * @param tokens the items
     * @return this request for chaining
     */
    public CreateTrade askingTokens(Trade... tokens) {
        return set("askingTokens", tokens);
    }

    /**
     * Sets the tokens (items) to be offered by the sender.
     *
     * @param tokens the items
     * @return this request for chaining
     */
    public CreateTrade offeringTokens(Trade... tokens) {
        return set("offeringTokens", tokens);
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public CreateTrade recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

}
