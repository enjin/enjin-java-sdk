package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SetApprovalForAll
        extends GraphQLRequest<SetApprovalForAll>
        implements TransactionFragmentArguments<SetApprovalForAll>,
        TransactionRequestArguments<SetApprovalForAll> {

    /**
     * TODO
     */
    public SetApprovalForAll() {
        super("enjin.sdk.shared.SetApprovalForAll");
    }

    /**
     * TODO
     * @param operatorAddress
     * @return
     */
    public SetApprovalForAll operatorAddress(String operatorAddress) {
        return set("operatorAddress", operatorAddress);
    }

    /**
     * TODO
     * @param approved
     * @return
     */
    public SetApprovalForAll approved(boolean approved) {
        return set("approved", approved);
    }

}
