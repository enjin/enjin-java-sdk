package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
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

    private List<Token> tokens;

    @SerializedName("eth_balance")
    private Double ethBalance;

    @SerializedName("enj_balance")
    private Double enjBalance;

    @SerializedName("all_tokens_balance")
    private JsonObject allTokensBalance;

    public Long getId() {
        return this.id;
    }

    public Long getAppId() {
        return this.appId;
    }

    public String getEthereumAddress() {
        return this.ethereumAddress;
    }

    public String getLinkingCode() {
        return this.linkingCode;
    }

    public JsonObject getCreatedAt() {
        return this.createdAt;
    }

    public JsonObject getUpdatedAt() {
        return this.updatedAt;
    }

    public List<IdentityField> getFields() {
        return this.fields;
    }

    public List<Token> getTokens() { return this.tokens; }

    public Double getEthBalance() {
        return this.ethBalance;
    }

    public Double getEnjBalance() {
        return this.enjBalance;
    }
}
