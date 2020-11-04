package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Models a blockchain transaction log.
 */
@EqualsAndHashCode
@Getter
public class TransactionLog {

    /**
     * -- Getter --
     *
     * @return the block number
     */
    private Integer blockNumber;

    /**
     * -- Getter --
     *
     * @return the originating address
     */
    private String address;

    /**
     * -- Getter --
     *
     * @return the hash of the transaction
     */
    private String transactionHash;

    /**
     * -- Getter --
     *
     * @return the list of data objects
     */
    private List<JsonObject> data;

    /**
     * -- Getter --
     *
     * @return the list of topics
     */
    private List<JsonObject> topics;

    /**
     * -- Getter --
     *
     * @return the transaction event
     */
    private TransactionEvent event;

}
