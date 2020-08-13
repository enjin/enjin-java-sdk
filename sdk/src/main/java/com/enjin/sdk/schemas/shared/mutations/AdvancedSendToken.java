package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Transfers;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class AdvancedSendToken
        extends GraphQLRequest<AdvancedSendToken>
        implements TransactionRequestArguments<AdvancedSendToken> {

    /**
     * TODO
     */
    public AdvancedSendToken() {
        super("enjin.sdk.shared.AdvancedSendToken");
    }

    /**
     * TODO
     * @param transfers
     * @return
     */
    public AdvancedSendToken transfers(Transfers... transfers) {
        return set("transfers", transfers);
    }

    /**
     * TODO
     * @param data
     * @return
     */
    public AdvancedSendToken data(String data) {
        return set("data", data);
    }

}
