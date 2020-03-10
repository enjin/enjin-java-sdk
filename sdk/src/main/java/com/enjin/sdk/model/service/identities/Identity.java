package com.enjin.sdk.model.service.identities;

import java.util.List;

import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.wallets.Wallet;
import com.enjin.sdk.service.identities.IdentitiesService;

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

    /**
     * The owned tokens.
     *
     * @return a list of owned tokens.
     */
    private List<Token> tokens;

    private Wallet wallet;

}
