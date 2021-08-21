package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting the transfer fee of a asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetTransferFee
        extends GraphQLRequest<SetTransferFee>
        implements ProjectTransactionRequestArguments<SetTransferFee> {

    /**
     * Sole constructor.
     */
    public SetTransferFee() {
        super("enjin.sdk.project.SetTransferFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetTransferFee assetId(String assetId) {
        return set("assetId", assetId);
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
