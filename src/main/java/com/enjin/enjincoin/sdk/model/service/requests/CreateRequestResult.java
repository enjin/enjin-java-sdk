package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CreateRequestResult {

    @SerializedName("CreateEnjinRequest")
    private Transaction request;

}
