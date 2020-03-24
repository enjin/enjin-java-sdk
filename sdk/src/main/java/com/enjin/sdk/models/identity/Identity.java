package com.enjin.sdk.models.identity;

import com.enjin.sdk.models.wallet.Wallet;
import com.enjin.sdk.services.identity.IdentitiesService;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform identity.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
@ToString
@Getter
public class Identity {

    /**
     * The identity id.
     *
     * @return the identity id.
     */
    private Integer id;

    /**
     * The app id.
     *
     * @return the app id.
     */
    private Integer appId;

    /**
     * The linking code.
     *
     * @return the linking code.
     */
    private String linkingCode;

    /**
     * The linking code qr.
     *
     * @return the linking code qr.
     */
    private String linkingCodeQr;

    private Wallet wallet;

    private String createdAt;

    private String updatedAt;

}
