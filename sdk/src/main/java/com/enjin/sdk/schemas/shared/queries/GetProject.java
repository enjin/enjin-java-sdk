package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting a project on the platform.
 *
 * @see com.enjin.sdk.models.Project
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public final class GetProject extends GraphQLRequest<GetProject> {

    /**
     * Sole constructor.
     */
    public GetProject() {
        super("enjin.sdk.shared.GetProject");
    }

    /**
     * Sets the project ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetProject id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the project name.
     *
     * @param name the name
     * @return this request for chaining
     */
    public GetProject name(String name) {
        return set("name", name);
    }

}
