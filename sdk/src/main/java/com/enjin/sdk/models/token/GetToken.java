package com.enjin.sdk.models.token;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * The results of a get token request.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class GetToken extends PaginationRequest<GetToken> implements TokenFragment<GetToken> {

    public GetToken appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The token id.
     *
     * @param tokenId the token id.
     *
     * @return the builder.
     */
    public GetToken tokenId(String tokenId) {
        set("id", tokenId);
        return this;
    }

}
