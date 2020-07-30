package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.inputs.PlayerFilter;
import com.enjin.sdk.schemas.shared.fragments.inputs.PlayerFragmentArguments;

/**
 * TODO
 */
public class GetPlayers
        extends GraphQLRequest<GetPlayers> // TODO: Switch to PaginationRequest.
        implements PlayerFragmentArguments<GetPlayers> {

    /**
     * TODO
     * @param filter
     * @return
     */
    public GetPlayers filter(PlayerFilter filter) {
        return set("filter", filter);
    }

}
