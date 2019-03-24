package com.enjin.enjincoin.sdk.client.service.requests.vo.data;

import com.enjin.enjincoin.sdk.client.service.requests.vo.Transaction;
import com.google.gson.annotations.SerializedName;

public class CreateRequestData {

    @SerializedName("CreateEnjinRequest")
    private Transaction request;

    public Transaction getRequest() {
        return this.request;
    }
}
