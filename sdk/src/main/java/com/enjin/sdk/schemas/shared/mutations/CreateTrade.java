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
     * Sets the assets the sender is asking for.
     *
     * @param assets the assets
     * @return this request for chaining
     */
    public CreateTrade askingAssets(Trade... assets) {
        return set("askingAssets", assets);
    }

    /**
     * Sets the assets to be offered by the sender.
     *
     * @param assets the assets
     * @return this request for chaining
     */
    public CreateTrade offeringAssets(Trade... assets) {
        return set("offeringAssets", assets);
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
