package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class SetMeltFee
        extends GraphQLRequest<SetMeltFee>
        implements TransactionFragmentArguments<SetMeltFee>,
        TransactionRequestArguments<SetMeltFee> {

    /**
     * TODO
     */
    public SetMeltFee() {
        super("enjin.sdk.project.SetMeltFee");
    }

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public SetMeltFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public SetMeltFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * TODO
     * @param meltFee
     * @return
     */
    public SetMeltFee meltFee(int meltFee) {
        return set("meltFee", meltFee);
    }

}
