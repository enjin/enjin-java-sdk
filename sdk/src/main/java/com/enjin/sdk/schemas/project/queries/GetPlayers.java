package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.PlayerFilter;
import com.enjin.sdk.schemas.shared.arguments.PaginationArguments;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * TODO
 */
public class GetPlayers
        extends GraphQLRequest<GetPlayers>
        implements PaginationArguments<GetPlayers>,
        PlayerFragmentArguments<GetPlayers> {

    /**
     * TODO
     */
    public GetPlayers() {
        super("enjin.sdk.project.GetPlayers");
    }

    /**
     * TODO
     * @param filter
     * @return
     */
    public GetPlayers filter(PlayerFilter filter) {
        return set("filter", filter);
    }

}
