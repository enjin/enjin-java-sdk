package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRequestsResult {

    @SerializedName("EnjinTransactions")
    private List<Transaction> requests;

    public List<Transaction> getRequests() {
        return this.requests;
    }

    public boolean isEmpty() {
        return this.requests == null || this.requests.isEmpty();
    }
}
