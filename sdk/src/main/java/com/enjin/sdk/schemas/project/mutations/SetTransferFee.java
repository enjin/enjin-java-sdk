package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.TokenTransferFeeSettings;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SetTransferFee
        extends GraphQLRequest<SetTransferFee>
        implements TransactionRequestArguments<SetTransferFee> {

    /**
     * TODO
     */
    public SetTransferFee() {
        super("enjin.sdk.project.SetTransferFee");
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SetTransferFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public SetTransferFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param transferFeeSettings
     * @return
     */
    public SetTransferFee transferFeeSettings(TokenTransferFeeSettings transferFeeSettings) {
        return set("transferFeeSettings", transferFeeSettings);
    }

}
