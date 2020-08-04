package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TokenTransferable;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SetTransferable
        extends GraphQLRequest<SetTransferable>
        implements TransactionRequestArguments<SetTransferable> {

    /**
     * TODO
     */
    public SetTransferable() {
        super("enjin.sdk.project.SetTransferable");
    }

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
