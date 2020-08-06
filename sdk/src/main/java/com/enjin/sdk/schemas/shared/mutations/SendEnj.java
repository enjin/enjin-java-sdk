package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SendEnj
        extends GraphQLRequest<SendEnj>
        implements TransactionFragmentArguments<SendEnj>,
        TransactionRequestArguments<SendEnj> {

    /**
     * TODO
     */
    public SendEnj() {
        super("enjin.sdk.shared.SendEnj");
    }

    /**
     * TODO
     * @param recipientAddress
     * @return
     */
    public SendEnj recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public SendEnj value(String value) {
        return set("value", value);
    }

}
