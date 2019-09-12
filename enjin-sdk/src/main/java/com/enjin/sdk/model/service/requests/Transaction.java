package com.enjin.sdk.model.service.requests;

import java.util.List;

import com.enjin.sdk.model.service.tokens.TokenEvent;
import com.enjin.sdk.service.requests.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a transaction request on the trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 * @see TransactionType
 * @see TransactionState
 */
@ToString
@Getter
public class Transaction {

    /**
     * The request id.
     *
     * @return the request id.
     */
    private Integer id;

    /**
     * The transaction id.
     *
     * @return the transaction id.
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * The app id.
     *
     * @return the app id.
     */
    @SerializedName("app_id")
    private Integer appId;

    /**
     * The identity id.
     *
     * @return the identity id.
     */
    @SerializedName("identity_id")
    private Integer identityId;

    /**
     * The transaction type.
     *
     * @return the transaction type.
     */
    private TransactionType type;

    /**
     * The recipient id.
     *
     * @return the recipient id.
     */
    @SerializedName("recipient_id")
    private Integer recipientId;

    /**
     * The recipient ethereum address.
     *
     * @return the recipient ethereum address.
     */
    @SerializedName("recipient_address")
    private String recipientAddress;

    /**
     * The token id.
     *
     * @return the token id.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The encoded data.
     *
     * @return the encoded data.
     */
    @SerializedName("encoded_data")
    private String encodedData;

    /**
     * The signed transaction.
     *
     * @return the signed transaction.
     */
    @SerializedName("signed_transaction")
    private String signedTransaction;

    /**
     * The signed backup transaction.
     *
     * @return the signed backup transaction.
     */
    @SerializedName("signed_backup_transaction")
    private String signedBackupTransaction;

    /**
     * The signed cancel transaction.
     *
     * @return the signed cancel transaction.
     */
    @SerializedName("signed_cancel_transaction")
    private String signedCancelTransaction;

    /**
     * The nonce.
     *
     * @return the nonce.
     */
    private String nonce;

    /**
     * The retry state.
     *
     * @return the retry state.
     */
    @SerializedName("retry_state")
    private String retryState;

    /**
     * The transaction state.
     *
     * @return the transaction state.
     */
    private TransactionState state;

    /**
     * The accepted state.
     *
     * @return the accepted state.
     */
    private Integer accepted;

    /**
     * The events associated with the transaction.
     *
     * @return the events;
     */
    private List<TokenEvent> events;

}
