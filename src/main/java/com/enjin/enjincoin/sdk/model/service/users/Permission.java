package com.enjin.enjincoin.sdk.model.service.users;

import lombok.Getter;

/**
 * Represents the permissions a role has.
 *
 * @author Evan Lindsay
 * @see Role
 */
@Getter
public class Permission {

    /**
     * The permission id.
     *
     * @return the id.
     */
    private Integer id;

    /**
     * The permission name.
     *
     * @return the name.
     */
    private String name;

}
