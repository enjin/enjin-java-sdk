package com.enjin.sdk.model.service.roles;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents the permissions a role has.
 *
 * @author Evan Lindsay
 * @see Role
 */
@Getter
@ToString
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
