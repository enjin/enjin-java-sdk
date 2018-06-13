package com.enjin.enjincoin.sdk.client.service.requests.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestsData {

    @SerializedName("EnjinTransactions")
    private List<JsonObject> requests;

    public List<JsonObject> getRequests() {
        return this.requests;
    }
}
