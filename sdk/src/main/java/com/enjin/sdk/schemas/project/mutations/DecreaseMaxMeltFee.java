package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class DecreaseMaxMeltFee
        extends GraphQLRequest<DecreaseMaxMeltFee>
        implements TransactionFragmentArguments<DecreaseMaxMeltFee>,
        TransactionRequestArguments<DecreaseMaxMeltFee> {

    /**
     * TODO
     */
    public DecreaseMaxMeltFee() {
        super("enjin.sdk.project.DecreaseMaxMeltFee");
    }

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
