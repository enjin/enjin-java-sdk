package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Models a transaction on the platform.
 */
@Getter
public class Request {

    /**
     * -- Getter --
     * @return the ID of this transaction
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the hash ID of this transaction
     */
    private String transactionId;

    /**
     * -- Getter --
     * @return the title of this transaction
     */
    private String title;

    /**
     * -- Getter --
     * @return the contract address
     */
    private String contract;

    /**
     * -- Getter --
     * @return the encoded data, ready for signing
     */
    private String encodedData;

    /**
     * -- Getter --
     * @return the transaction type
     */
    private RequestType type;

    /**
     * -- Getter --
     * @return the icon URL for this transaction
     */
    private String icon;

    /**
     * -- Getter --
     * @return the value of this transaction
     */
    private String value;

    /**
     * -- Getter --
     * @return the signed transaction string
     */
    private String signedTransaction;

    /**
     * -- Getter --
     * @return the signed transaction string
     */
    private String signedBackupTransaction;

    /**
     * -- Getter --
     * @return the signed transaction string
     */
    private String signedCancelTransaction;

    /**
     * -- Getter --
     * @return the error message
     */
    private String error;

    /**
     * -- Getter --
     * @return the nonce
     */
    private String nonce;

    /**
     * -- Getter --
     * @return the retry state
     */
    private String retryState;

    /**
     * -- Getter --
     * @return the transaction state
     */
    private RequestState state;

    /**
     * -- Getter --
     * @return whether the transaction was accepted
     */
    private Boolean accepted;

    /**
     * -- Getter --
     * @return the receipt
     */
    private JsonObject receipt;

    /**
     * -- Getter --
     * @return the token (item) ID for this transaction
     */
    private String tokenId;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was created
     */
    private String createdAt;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was last updated
     */
    private String updatedAt;

}
