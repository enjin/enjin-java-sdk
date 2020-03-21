package com.enjin.sdk.model.service.tokens;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.tokens.TokensService;

/**
 * The results of a get token request.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class GetToken extends PaginationRequest<GetToken> {

    public GetToken appId(Integer appId) {
        withVariable("appId", appId);
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
        withVariable("id", tokenId);
        return this;
    }

}
