package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class Message
        extends GraphQLRequest<Message>
        implements TransactionRequestArguments<Message> {

    /**
     * TODO
     */
    public Message() {
        super("enjin.sdk.shared.Message");
    }

    /**
     * TODO
     * @param message
     * @return
     */
    public Message message(String message) {
        return set("message", message);
    }

}
