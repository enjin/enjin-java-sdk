package com.enjin.sdk.models.user;

import java.util.List;

import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.services.user.UsersService;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform user.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
@Getter
@ToString
public class User {

    /**
     * The user id.
     *
     * @return the id.
     */
    private Integer id;

    /**
     * The user name.
     *
     * @return the name.
     */
    private String name;

    /**
     * The users access tokens.
     *
     * @return the access tokens.
     */
    private List<AccessToken> accessTokens;

    private Boolean isPlayer;

    private Boolean emailVerified;

    /**
     * The users identities.
     *
     * @return the identities.
     */
    private List<Identity> identities;

    private String createdAt;

    private String updatedAt;

}
