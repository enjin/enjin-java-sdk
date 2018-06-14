package com.enjin.enjincoin.sdk.client.service.requests.vo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    private Integer id;

    @SerializedName("transaction_id")
    private String transactionId;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("identity_id")
    private Integer identityId;

    private String type;

    @SerializedName("recipient_id")
    private Integer recipientId;

    @SerializedName("recipient_address")
    private String recipientAddress;

    @SerializedName("token_id")
    private Integer tokenId;

    private String title;

    private String icon;

    private Integer value;

    @SerializedName("encoded_data")
    private String encodedData;

    private String state;

    private Integer accepted;

    @SerializedName("created_at")
    private JsonObject createdAt;

    @SerializedName("updated_at")
    private JsonObject updatedAt;

    public Integer getId() {
        return this.id;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public Integer getAppId() {
        return this.appId;
    }

    public Integer getIdentityId() {
        return this.identityId;
    }

    public String getType() {
        return this.type;
    }

    public Integer getRecipientId() {
        return this.recipientId;
    }

    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    public Integer getTokenId() {
        return this.tokenId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIcon() {
        return this.icon;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getEncodedData() {
        return this.encodedData;
    }

    public String getState() {
        return this.state;
    }

    public Integer getAccepted() {
        return this.accepted;
    }

    public JsonObject getCreatedAt() {
        return this.createdAt;
    }

    public JsonObject getUpdatedAt() {
        return this.updatedAt;
    }
}
