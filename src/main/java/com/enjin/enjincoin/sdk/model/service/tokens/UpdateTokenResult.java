package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of an update token request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.tokens.TokensService
 */
@Getter
public class UpdateTokenResult {

    /**
     * The updated token.
     *
     * @return the updated token.
     */
    @SerializedName("UpdateEnjinToken")
    private Token token;

}
