package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of a create user request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
@Getter
public class CreateUserResult {

    /**
     * The created user.
     *
     * @return the created user.
     */
    @SerializedName("CreateUser")
    private User user;

}
