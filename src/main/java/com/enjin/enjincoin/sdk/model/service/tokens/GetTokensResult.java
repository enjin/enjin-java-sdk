package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

/**
 * The result of a get tokens request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
@Getter
public class GetTokensResult {

    /**
     * The tokens that match the query parameters.
     *
     * @return a list of tokens that match the query parameters.
     */
    @SerializedName("EnjinTokens")
    private List<Token> tokens;

}
