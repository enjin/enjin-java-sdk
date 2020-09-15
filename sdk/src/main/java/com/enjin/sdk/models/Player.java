package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Models a player on a application.
 */
@Getter
public class Player {

    /**
     * -- Getter --
     * @return the ID of this player
     */
    private String id;

    /**
     * -- Getter --
     * @return the linking code for this player
     */
    private String linkingCode;

    /**
     * -- Getter --
     * @return the URL for the QR linking code
     */
    private String linkingCodeQr;

    /**
     * -- Getter --
     * @return the wallet for this player
     */
    private JsonObject wallet;

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
