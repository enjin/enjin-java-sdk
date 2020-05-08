package com.enjin.sdk.models.user;

import java.util.List;

import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.services.user.UsersService;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform User.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
@Getter
@ToString
public class User {

    /**
     * -- GETTER --
     * Returns the user id.
     *
     * @return the id.
     */
    private Integer id;

    /**
     * -- GETTER --
     * Returns the user name.
     *
     * @return the name.
     */
    private String name;

    /**
     * -- GETTER --
     * Returns the users access tokens.
     *
     * @return the access tokens.
     */
    private List<AccessToken> accessTokens;

    /**
     * -- GETTER --
     * Determines if the user is a player.
     *
     * @return true when the user is a player, false otherwise.
     */
    private Boolean isPlayer;

    /**
     * -- GETTER --
     * Determines if the user has a verified email address.
     *
     * @return true when this user has a verified email address, false otherwise.
     */
    private Boolean emailVerified;

    /**
     * -- GETTER --
     * Returns the users identities.
     *
     * @return the identities.
     */
    private List<Identity> identities;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the user was created.
     *
     * @return the time the user was created.
     */
    private String createdAt;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the user was last updated.
     *
     * @return the time the user was last updated.
     */
    private String updatedAt;

}
