package com.enjin.sdk.model.service.users;

import java.util.List;

import com.enjin.sdk.model.service.identities.Identity;
import com.enjin.sdk.service.users.UsersService;

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

    /**
     * The users identities.
     *
     * @return the identities.
     */
    private List<Identity> identities;

}
