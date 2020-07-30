package com.enjin.sdk.schemas.shared.fragments;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * TODO
 */
@Getter
public class Player {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String id;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String linkingCode;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String linkingCodeQr;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private JsonObject wallet;
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
