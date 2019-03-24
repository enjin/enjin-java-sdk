package com.enjin.enjincoin.sdk.client.service.requests.vo.data;

import com.enjin.enjincoin.sdk.client.service.requests.vo.Transaction;
import com.google.gson.annotations.SerializedName;

public class UpdateRequestData {

    @SerializedName("UpdateEnjinRequest")
    private Transaction request;

    public Transaction getRequest() {
        return this.request;
    }
}
