package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request to sign a message to prove wallet ownership.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class Message
        extends GraphQLRequest<Message>
        implements ProjectTransactionRequestArguments<Message> {

    /**
     * Sole constructor.
     */
    public Message() {
        super("enjin.sdk.project.Message");
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
