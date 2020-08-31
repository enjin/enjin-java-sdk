package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TokenTransferable;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting if a item may be transferred.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class SetTransferable
        extends GraphQLRequest<SetTransferable>
        implements TransactionRequestArguments<SetTransferable> {

    /**
     * Sole constructor.
     */
    public SetTransferable() {
        super("enjin.sdk.project.SetTransferable");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SetTransferable tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public SetTransferable tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the new transfer mode.
     *
     * @param transferable the new mode
     * @return this request for chaining
     */
    public SetTransferable transferable(TokenTransferable transferable) {
        return set("transferable", transferable);
    }

}
