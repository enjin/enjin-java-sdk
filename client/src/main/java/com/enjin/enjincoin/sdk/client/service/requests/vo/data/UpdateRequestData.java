package com.enjin.enjincoin.sdk.client.service.requests.vo.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class UpdateRequestData {

    @SerializedName("UpdateEnjinRequest")
    private JsonObject request;

    public JsonObject getRequest() {
        return this.request;
    }
}
