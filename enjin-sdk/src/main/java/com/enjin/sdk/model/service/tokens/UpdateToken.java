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
        withParameter("token_id", tokenId);
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
        withParameter("app_id", appId);
        return this;
    }

    /**
     * Whether the token should be updated from the blockchain or not.
     *
     * @return the builder.
     */
    public UpdateToken updateFromBlockchain() {
        withParameter("fromBlockchain", true);
        return this;
    }

}
