package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class GetTokensResult {

    @SerializedName("EnjinTokens")
    private List<Token> tokens;

}
