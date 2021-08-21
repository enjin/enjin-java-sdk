package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request to obtain the access token for the project.
 *
 * @see com.enjin.sdk.models.AccessToken
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class AuthProject extends GraphQLRequest<AuthProject> {

    /**
     * Sole constructor.
     */
    public AuthProject() {
        super("enjin.sdk.project.AuthProject");
    }

    /**
     * Sets the project UUID.
     *
     * @param uuid the UUID
     * @return this request for chaining
     */
    public AuthProject uuid(String uuid) {
        return set("uuid", uuid);
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
