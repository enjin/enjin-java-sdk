package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Identity {

    private Long id;

    @SerializedName("app_id")
    private Long appId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private String linkingCode;

    @SerializedName("created_at")
    private JsonObject createdAt;

    @SerializedName("updated_at")
    private JsonObject updatedAt;

    private List<IdentityField> fields;

    @SerializedName("eth_balance")
    private Double ethBalance;

    @SerializedName("enj_balance")
    private Double enjBalance;

}
