package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting the transfer fee of a item.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class SetTransferFee
        extends GraphQLRequest<SetTransferFee>
        implements TransactionRequestArguments<SetTransferFee> {

    /**
     * Sole constructor.
     */
    public SetTransferFee() {
        super("enjin.sdk.project.SetTransferFee");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SetTransferFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public SetTransferFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the new transfer fee value in Wei.
     *
     * @param transferFee the new transfer fee
     * @return this request for chaining
     */
    public SetTransferFee transferFee(String transferFee) {
        return set("transferFee", transferFee);
    }

}
