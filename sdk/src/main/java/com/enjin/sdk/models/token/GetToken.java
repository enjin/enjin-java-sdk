package com.enjin.sdk.models.token;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.token.TokensService;

/**
 * An object class for getting a token from the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see TokensService
 */
public class GetToken extends PaginationRequest<GetToken> implements TokenFragment<GetToken> {

    /**
     * The application's id.
     *
     * @param appId the app id.
     * @return      this request.
     */
    public GetToken appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return        this request.
     */
    public GetToken tokenId(String tokenId) {
        set("id", tokenId);
        return this;
    }

}
