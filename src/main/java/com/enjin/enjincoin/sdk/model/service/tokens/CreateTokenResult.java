package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a create token request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
@Getter
public class CreateTokenResult {

    /**
     * The new token.
     *
     * @return the new token.
     */
    @SerializedName("CreateEnjinToken")
    private Token token;

}
