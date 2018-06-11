package com.enjin.enjincoin.sdk.client.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GraphQLResponse {

    private JsonObject data;

    private JsonArray errors;

    public JsonObject data() {
        return this.data;
    }

    public JsonArray errors() {
        return this.errors;
    }

    public boolean isSuccessful() {
        return this.errors == null;
    }
}
