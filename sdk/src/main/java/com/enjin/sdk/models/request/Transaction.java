package com.enjin.sdk.models.request;

import java.util.List;

import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.TokenEvent;
import com.enjin.sdk.services.request.RequestsService;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a transaction request on the Trusted Platform.
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
     * -- GETTER --
     * Returns the id of the transaction.
     *
     * @return the id
     */
    private Integer id;

    /**
     * -- GETTER --
     * Returns the transaction hash returned by the Ethereum network after executing the request.
     *
     * @return the hash
     */
    private String transactionId;

    /**
     * -- GETTER --
     * Returns the id of the {@link App} the transaction belongs to.
     *
     * @return the app id
     */
    private Integer appId;

    /**
     * -- GETTER --
     * Returns the id of the {@link Identity} linked to the transaction.
     *
     * @return the identity id
     */
    private Integer identityId;

    /**
     * -- GETTER --
     * Returns the recipient's {@link Identity} id.
     *
     * @return the identity id
     */
    private Integer recipientId;

    /**
     * -- GETTER --
     * Returns the recipient's Ethereum address.
     *
     * @return the Ethereum address
     */
    private String recipientAddress;

    /**
     * -- GETTER --
     * Returns the transaction's type.
     *
     * @return the type
     */
    private TransactionType type;

    /**
     * -- GETTER --
     * Returns the id of the {@link Token} in the transaction.
     *
     * @return
     */
    private String tokenId;

    /**
     * -- GETTER --
     * Returns the value of the transaction.
     *
     * @return the value
     */
    private String value;

    /**
     * -- GETTER --
     * Returns the title of the transaction.
     *
     * @return the title
     */
    private String title;

    /**
     * -- GETTER --
     * Returns the icon url for the transaction.
     *
     * @return the url
     */
    private String icon;

    /**
     * -- GETTER --
     * Returns the error message returned from the blockchain if the broadcast was unsuccessful.
     *
     * @return the error message
     */
    private String error;

    /**
     * -- GETTER --
     * Returns the encoded data, ready for signing.
     *
     * @return the data
     */
    private String encodedData;

    /**
     * -- GETTER --
     * Returns the signed transaction string.
     *
     * @return the signed string
     */
    private String signedTransaction;

    /**
     * -- GETTER --
     * Returns the signed backup transaction string.
     *
     * @return the signed string
     */
    private String signedBackupTransaction;

    /**
     * -- GETTER --
     * Returns the signed cancel transaction string.
     *
     * @return the signed string
     */
    private String signedCancelTransaction;

    /**
     * -- GETTER --
     * Returns the nonce string.
     *
     * @return the nonce
     */
    private String nonce;

    /**
     * -- GETTER --
     * Returns the retry state string.
     *
     * @return the retry state
     */
    private String retryState;

    /**
     * -- GETTER --
     * Returns the transaction's state.
     *
     * @return the state
     */
    private TransactionState state;

    /**
     * -- GETTER --
     * Returns whether the request has been accepted.
     *
     * @return the status
     */
    private Integer accepted;

    /**
     * -- GETTER --
     * Returns the transaction receipt.
     *
     * @return the receipt
     */
    private JsonObject receipt;

    /**
     * -- GETTER --
     * Returns the events for this transaction.
     *
     * @return the events
     */
    private List<TokenEvent> events;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the transaction was created.
     *
     * @return the time the transaction was created
     */
    private String createdAt;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the transaction was last updated.
     *
     * @return the last time the transaction was updated
     */
    private String updatedAt;

}
