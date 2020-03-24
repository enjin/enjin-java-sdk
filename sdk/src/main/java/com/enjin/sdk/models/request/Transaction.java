package com.enjin.sdk.models.request;

import java.util.List;

import com.enjin.sdk.models.token.event.TokenEvent;
import com.enjin.sdk.services.request.RequestsService;

import com.google.gson.JsonObject;
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

    private Integer id;

    private String transactionId;

    private Integer appId;

    private Integer identityId;

    private Integer recipientId;

    private String recipientAddress;

    private TransactionType type;

    private String tokenId;

    private String value;

    private String title;

    private String icon;

    private String error;

    private String encodedData;

    private String signedTransaction;

    private String signedBackupTransaction;

    private String signedCancelTransaction;

    private String nonce;

    private String retryState;

    private TransactionState state;

    private Integer accepted;

    private JsonObject receipt;

    private List<TokenEvent> events;

    private String createdAt;

    private String updatedAt;

}
