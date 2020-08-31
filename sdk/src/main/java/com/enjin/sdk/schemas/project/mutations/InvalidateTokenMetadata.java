package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for invalidating the cached metadata of a token (item) on the platform.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class InvalidateTokenMetadata extends GraphQLRequest<InvalidateTokenMetadata> {

    /**
     * Sole constructor.
     */
    public InvalidateTokenMetadata() {
        super("enjin.sdk.project.InvalidateTokenMetadata");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public InvalidateTokenMetadata id(String id) {
        return set("id", id);
    }

}
