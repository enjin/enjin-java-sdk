package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SendToken
        extends GraphQLRequest<SendToken>
        implements TransactionRequestArguments<SendToken> {

    /**
     * TODO
     */
    public SendToken() {
        super("enjin.sdk.shared.SendToken");
    }

    /**
     * TODO
     * @param recipientAddress
     * @return
     */
    public SendToken recipientAddress(String recipientAddress) {
        return set("recipientAddress", recipientAddress);
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SendToken tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public SendToken tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public SendToken value(String value) {
        return set("value", value);
    }

    /**
     * TODO
     * @param data
     * @return
     */
    public SendToken data(String data) {
        return set("data", data);
    }

}
