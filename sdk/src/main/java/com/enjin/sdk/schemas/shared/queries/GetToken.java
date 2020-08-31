package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TokenFragmentArguments;

/**
 * Request for getting a token (item) on the platform.
 *
 * @see com.enjin.sdk.models.Token
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class GetToken
        extends GraphQLRequest<GetToken>
        implements TokenFragmentArguments<GetToken> {

    /**
     * Sole constructor.
     */
    public GetToken() {
        super("enjin.sdk.shared.GetToken");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetToken id(String id) {
        return set("id", id);
    }

}
