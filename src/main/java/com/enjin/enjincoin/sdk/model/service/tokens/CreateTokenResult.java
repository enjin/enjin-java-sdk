package com.enjin.enjincoin.sdk.model.service.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CreateTokenResult {

    @SerializedName("CreateEnjinToken")
    private Token token;

}
