package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a transaction on the platform.
 */
@EqualsAndHashCode
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
     * @return the transaction type
     */
    private RequestType type;

    /**
     * -- Getter --
     * @return the value of this transaction
     */
    private String value;

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
     * @return whether the wallet is a project wallet.
     */
    private Boolean projectWallet;

    /**
     * -- Getter --
     * @return the blockchain data of this transaction
     */
    private BlockchainData blockchainData;

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
