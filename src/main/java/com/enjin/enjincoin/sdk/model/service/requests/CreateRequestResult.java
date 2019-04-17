package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;

public class CreateRequestResult {

    @SerializedName("CreateEnjinRequest")
    private Transaction request;

    public Transaction getRequest() {
        return this.request;
    }
}
