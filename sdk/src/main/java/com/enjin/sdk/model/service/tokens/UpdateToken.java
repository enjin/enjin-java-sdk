package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.tokens.TokensService;

/**
 * The result of an update token request.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class UpdateToken extends GraphQLRequest<UpdateToken> {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public UpdateToken tokenId(String tokenId) {
        withParameter("id", tokenId);
        return this;
    }

    /**
     * The app id.
     *
     * @param appId the app id.
     *
     * @return the builder.
     */
    public UpdateToken appId(int appId) {
        withParameter("appId", appId);
        return this;
    }

}
