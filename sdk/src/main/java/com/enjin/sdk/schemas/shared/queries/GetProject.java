package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public final class GetProject extends GraphQLRequest<GetProject> {

    /**
     * TODO
     */
    public GetProject() {
        super("enjin.sdk.shared.GetProject");
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public GetProject id(int id) {
        return set("id", id);
    }

    /**
     * TODO
     * @param name
     * @return
     */
    public GetProject name(String name) {
        return set("name", name);
    }

}
