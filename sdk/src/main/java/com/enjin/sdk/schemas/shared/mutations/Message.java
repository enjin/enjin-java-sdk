package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request to sign a message to prove wallet ownership.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class Message
        extends GraphQLRequest<Message>
        implements TransactionRequestArguments<Message> {

    /**
     * Sole constructor.
     */
    public Message() {
        super("enjin.sdk.shared.Message");
    }

    /**
     * Sets the message to sign.
     *
     * @param message the message
     * @return this request for chaining
     */
    public Message message(String message) {
        return set("message", message);
    }

}
