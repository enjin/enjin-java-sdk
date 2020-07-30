package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public class InvalidateTokenMetadata extends GraphQLRequest<InvalidateTokenMetadata> {

    /**
     * TODO
     * @param id
     * @return
     */
    public InvalidateTokenMetadata id(String id) {
        return set("id", id);
    }

}
