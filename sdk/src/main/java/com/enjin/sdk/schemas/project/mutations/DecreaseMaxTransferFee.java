package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class DecreaseMaxTransferFee
        extends GraphQLRequest<DecreaseMaxTransferFee>
        implements TransactionRequestArguments<DecreaseMaxTransferFee> {

    /**
     * TODO
     */
    public DecreaseMaxTransferFee() {
        super("enjin.sdk.project.DecreaseMaxTransferFee");
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public DecreaseMaxTransferFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public DecreaseMaxTransferFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param maxTransferFee
     * @return
     */
    public DecreaseMaxTransferFee maxTransferFee(int maxTransferFee) {
        return set("maxTransferFee", maxTransferFee);
    }

}
