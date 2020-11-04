package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Models a blockchain transaction event.
 */
@EqualsAndHashCode
@Getter
public class TransactionEvent {

    /**
     * -- Getter --
     *
     * @return the name
     */
    private String name;

    /**
     * -- Getter --
     *
     * @return the parameters
     */
    private List<JsonObject> inputs;

    /**
     * -- Getter --
     *
     * @return the non-indexed parameters
     */
    private List<JsonObject> nonIndexedInputs;

    /**
     * -- Getter --
     *
     * @return the indexed parameters
     */
    private List<JsonObject> indexedInputs;

    /**
     * -- Getter --
     *
     * @return the event signature, or null if anonymous
     */
    private String signature;

    /**
     * -- Getter --
     *
     * @return the encoded signature
     */
    private String encodedSignature;

}
