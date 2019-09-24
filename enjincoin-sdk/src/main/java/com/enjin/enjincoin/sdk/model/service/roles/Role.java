package com.enjin.enjincoin.sdk.model.service.roles;

import com.enjin.enjincoin.sdk.model.service.users.User;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Represents the permissions a user has on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see User
 */
@Getter
@ToString
public class Role {

    /**
     * The role id.
     *
     * @return the id.
     */
    private Integer id;

    /**
     * The role name.
     *
     * @return the name.
     */
    private String name;

    /**
     * The roles permissions.
     *
     * @return the permissions.
     */
    private List<Permission> permissions;

    /**
     * The roles app id.
     *
     * @return the app id.
     */
    @SerializedName("app_id")
    private Integer appId;

}
