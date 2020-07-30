package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.fragments.TokenTransferable;
import com.enjin.sdk.schemas.shared.fragments.inputs.TransactionRequestArguments;

/**
 * TODO
 */
public class SetTransferable
        extends GraphQLRequest<SetTransferable>
        implements TransactionRequestArguments<SetTransferable> {

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SetTransferable tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public SetTransferable tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param transferable
     * @return
     */
    public SetTransferable transferable(TokenTransferable transferable) {
        return set("transferable", transferable);
    }

}
