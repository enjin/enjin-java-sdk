package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.fragments.inputs.TransactionRequestArguments;

/**
 * TODO
 */
public class DecreaseMaxMeltFee
        extends GraphQLRequest<DecreaseMaxMeltFee>
        implements TransactionRequestArguments<DecreaseMaxMeltFee> {

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public DecreaseMaxMeltFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public DecreaseMaxMeltFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param maxMeltFee
     * @return
     */
    public DecreaseMaxMeltFee maxMeltFee(int maxMeltFee) {
        return set("maxMeltFee", maxMeltFee);
    }

}
