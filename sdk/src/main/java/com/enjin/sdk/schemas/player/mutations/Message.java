package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request to sign a message to prove wallet ownership.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class Message
        extends GraphQLRequest<Message>
        implements TransactionFragmentArguments<Message> {

    /**
     * Sole constructor.
     */
    public Message() {
        super("enjin.sdk.player.Message");
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
