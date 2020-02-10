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
    private String transactionId;

    private String error;

    /**
     * The app id.
     *
     * @return the app id.
     */
    private Integer appId;

    /**
     * The identity id.
     *
     * @return the identity id.
     */
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
    private Integer recipientId;

    /**
     * The recipient ethereum address.
     *
     * @return the recipient ethereum address.
     */
    private String recipientAddress;

    /**
     * The token id.
     *
     * @return the token id.
     */
    private String tokenId;

    private String title;

    private String icon;

    private String value;

    /**
     * The encoded data.
     *
     * @return the encoded data.
     */
    private String encodedData;

    /**
     * The signed transaction.
     *
     * @return the signed transaction.
     */
    private String signedTransaction;

    /**
     * The signed backup transaction.
     *
     * @return the signed backup transaction.
     */
    private String signedBackupTransaction;

    /**
     * The signed cancel transaction.
     *
     * @return the signed cancel transaction.
     */
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
