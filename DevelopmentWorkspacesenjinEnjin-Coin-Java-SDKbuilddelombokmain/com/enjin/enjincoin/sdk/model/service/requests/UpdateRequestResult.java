package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;

public class UpdateRequestResult {

    @SerializedName("UpdateEnjinRequest")
    private Transaction request;

    public Transaction getRequest() {
        return this.request;
    }
}
