package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.inputs.MintInput;
import com.enjin.sdk.schemas.shared.fragments.inputs.TransactionRequestArguments;

import java.util.Collection;

/**
 * TODO
 */
public class MintToken
        extends GraphQLRequest<MintToken>
        implements TransactionRequestArguments<MintToken> {

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public MintToken tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * TODO
     * @param mints
     * @return
     */
    public MintToken mints(Collection<MintInput> mints) {
        return set("mints", mints);
    }

}
