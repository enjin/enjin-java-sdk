package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a player on a application.
 */
@EqualsAndHashCode
@Getter
public class Player {

    /**
     * -- Getter --
     * @return the ID of this player
     */
    private String id;

    /**
     * -- Getter --
     * @return the linking info for this player
     */
    private LinkingInfo linkingInfo;

    /**
     * -- Getter --
     * @return the wallet for this player
     */
    private Wallet wallet;

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
