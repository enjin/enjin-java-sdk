package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request to obtain the access token for the project.
 *
 * @see com.enjin.sdk.models.AccessToken
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class AuthProject extends GraphQLRequest<AuthProject> {

    /**
     * Sole constructor.
     */
    public AuthProject() {
        super("enjin.sdk.project.AuthProject");
    }

    /**
     * Sets the project ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public AuthProject id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the secret.
     *
     * @param secret the secret
     * @return this request for chaining
     */
    public AuthProject secret(String secret) {
        return set("secret", secret);
    }

}
