package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

public class CreateIdentityRequestBody {

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("ethereum_address")
    public String ethereumAddress;

    @SerializedName("fields")
    public IdentityField[] fields;

    public CreateIdentityRequestBody(int appId) {
        this(appId, null);
    }

    public CreateIdentityRequestBody(int appId, IdentityField[] fields) {
        this(appId, null, fields);
    }

    public CreateIdentityRequestBody(int appId, String ethereumAddress, IdentityField[] fields) {
        this.appId = appId;
        this.ethereumAddress = ethereumAddress;
        this.fields = fields;
    }

}
