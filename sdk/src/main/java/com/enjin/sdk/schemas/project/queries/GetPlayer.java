package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * TODO
 */
public class GetPlayer
        extends GraphQLRequest<GetPlayer>
        implements PlayerFragmentArguments<GetPlayer> {

    /**
     * TODO
     * @param id
     * @return
     */
    public GetPlayer id(String id) {
        return set("id", id);
    }

}
