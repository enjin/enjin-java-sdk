package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public class CreatePlayer extends GraphQLRequest<CreatePlayer> {

    /**
     * TODO
     * @param id
     * @return
     */
    public CreatePlayer id(String id) {
        return set("id", id);
    }

}
