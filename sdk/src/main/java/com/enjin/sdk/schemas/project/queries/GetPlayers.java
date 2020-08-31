package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.PlayerFilter;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * Request for getting players on the application.
 *
 * @see com.enjin.sdk.models.Player
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class GetPlayers
        extends GraphQLRequest<GetPlayers>
        implements PlayerFragmentArguments<GetPlayers>,
        PaginationArguments<GetPlayers> {

    /**
     * Sole constructor.
     */
    public GetPlayers() {
        super("enjin.sdk.project.GetPlayers");
    }

    /**
     * Sets the filter the request will use.
     *
     * @param filter the filter
     * @return this request for chaining
     */
    public GetPlayers filter(PlayerFilter filter) {
        return set("filter", filter);
    }

}
