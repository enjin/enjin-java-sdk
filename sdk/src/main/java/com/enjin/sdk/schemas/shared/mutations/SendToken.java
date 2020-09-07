package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for sending a token (item).
 *
 * @see AdvancedSendToken
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class SendToken
        extends GraphQLRequest<SendToken>
        implements TransactionRequestArguments<SendToken> {

    /**
     * Sole constructor.
     */
    public SendToken() {
        super("enjin.sdk.shared.SendToken");
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public SendToken recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SendToken tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public SendToken tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the amount to send.
     *
     * @param value the amount
     * @return this request for chaining
     */
    public SendToken value(String value) {
        return set("value", value);
    }

    /**
     * Sets the data to forward with the transaction.
     *
     * @param data the data
     * @return this request for chaining
     */
    public SendToken data(String data) {
        return set("data", data);
    }

}
