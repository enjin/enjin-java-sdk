package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.MintInput;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

import java.util.Collection;

/**
 * Request for minting a token (item).
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class MintToken
        extends GraphQLRequest<MintToken>
        implements TransactionRequestArguments<MintToken> {

    /**
     * Sole constructor.
     */
    public MintToken() {
        super("enjin.sdk.project.MintToken");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public MintToken tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the mints to be performed.
     *
     * @param mints the mints
     * @return this request for chaining
     */
    public MintToken mints(Collection<MintInput> mints) {
        return set("mints", mints);
    }

}
