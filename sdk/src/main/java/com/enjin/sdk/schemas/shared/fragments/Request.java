package com.enjin.sdk.schemas.shared.fragments;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * TODO
 */
@Getter
public class Request {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer id;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String transactionId;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String title;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String contract;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String encodedData;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private RequestType type;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String icon;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String value;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String signedTransaction;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String signedBackupTransaction;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String signedCancelTransaction;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String error;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String nonce;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String retryState;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private RequestState state;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Boolean accepted;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private JsonObject receipt;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String tokenId;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String createdAt;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String updatedAt;

}
