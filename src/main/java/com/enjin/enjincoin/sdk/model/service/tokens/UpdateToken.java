package com.enjin.enjincoin.sdk.model.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * The result of an update token request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
public class UpdateToken extends GraphQLRequest<UpdateToken> {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public UpdateToken withTokenId(String tokenId) {
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
    public UpdateToken withAppId(int appId) {
        withParameter("app_id", appId);
        return this;
    }

    /**
     * Whether the token should be updated from the blockchain or not.
     *
     * @param fromBlockchain update from the blockchain?
     *
     * @return the builder.
     */
    public UpdateToken withFromBlockchain(boolean fromBlockchain) {
        withParameter("fromBlockchain", fromBlockchain);
        return this;
    }

}
