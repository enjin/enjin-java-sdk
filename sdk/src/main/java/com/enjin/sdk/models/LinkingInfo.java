package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the linking information for a {@link Player}.
 */
@EqualsAndHashCode
@Getter
public class LinkingInfo {

    /**
     * -- Getter --
     * @return the linking code for the player
     */
    private String code;

    /**
     * -- Getter --
     * @return the URL for the QR linking code
     */
    private String qr;

}
