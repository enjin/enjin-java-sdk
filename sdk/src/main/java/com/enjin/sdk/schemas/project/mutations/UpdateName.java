package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request to update the name of a token (item) on the platform.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class UpdateName
        extends GraphQLRequest<UpdateName>
        implements TransactionRequestArguments<UpdateName> {

    /**
     * Sole constructor.
     */
    public UpdateName() {
        super("enjin.sdk.project.UpdateName");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public UpdateName tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public UpdateName tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the name the token (item) will update to.
     *
     * @param name the new name
     * @return this request for chaining
     */
    public UpdateName name(String name) {
        return set("name", name);
    }

}
