package com.enjin.enjincoin.sdk.model.service.requests;

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

    @SerializedName("encoded_data")
    private String encodedData;

    @SerializedName("signed_transaction")
    private String signedTransaction;


    @SerializedName("signed_backup_transaction")
    private String signedBackupTransaction;

    @SerializedName("signed_cancel_transaction")
    private String signedCancelTransaction;

    private String nonce;

    @SerializedName("retry_state")
    private String retryState;

    private TransactionState state;

    private Integer accepted;

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

    public String getEncodedData() {
        return this.encodedData;
    }

    public TransactionState getState() {
        return this.state;
    }

    public Integer getAccepted() {
        return this.accepted;
    }
}
