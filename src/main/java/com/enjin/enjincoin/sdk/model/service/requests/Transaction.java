package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@ToString
@Getter
public class Transaction {

    private BigInteger id;

    @SerializedName("transaction_id")
    private String transactionId;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("identity_id")
    private Integer identityId;

    private TransactionType type;

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

}
