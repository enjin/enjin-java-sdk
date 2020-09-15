package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for sending send ENJ.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class SendEnj
        extends GraphQLRequest<SendEnj>
        implements TransactionRequestArguments<SendEnj> {

    /**
     * Sole constructor.
     */
    public SendEnj() {
        super("enjin.sdk.shared.SendEnj");
    }

    /**
     * Sets the wallet address of the recipient.
     *
     * @param recipientAddress the address
     * @return this request for chaining
     */
    public SendEnj recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * Sets the amount of ENJ to send.
     * <br>
     * <p>
     *     The value is in Wei as 10^18 (e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the value
     * @return this request for chaining
     */
    public SendEnj value(String value) {
        return set("value", value);
    }

}
