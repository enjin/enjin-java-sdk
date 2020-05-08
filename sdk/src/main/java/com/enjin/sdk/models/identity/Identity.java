package com.enjin.sdk.models.identity;

import com.enjin.sdk.models.wallet.Wallet;
import com.enjin.sdk.services.identity.IdentitiesService;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform Identity.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
@ToString
@Getter
public class Identity {

    /**
     * -- GETTER --
     * Returns the identity id.
     *
     * @return the identity id.
     */
    private Integer id;

    /**
     * -- GETTER --
     * Returns the application id.
     *
     * @return the app id.
     */
    private Integer appId;

    /**
     * -- GETTER --
     * Returns the linking code.
     *
     * @return the linking code.
     */
    private String linkingCode;

    /**
     * -- GETTER --
     * Returns the url to the linking code's qr image.
     *
     * @return the url.
     */
    private String linkingCodeQr;

    /**
     * -- GETTER --
     * Returns the identity's wallet.
     *
     * @return the wallet.
     */
    private Wallet wallet;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the identity was created.
     *
     * @return the time the identity was created.
     */
    private String createdAt;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the identity was last updated.
     *
     * @return the time the identity was last updated.
     */
    private String updatedAt;

}
