package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * The result of logging in a user.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
@Getter
public class LoginUserResult {

    /**
     * The logged in user.
     *
     * @return the logged in user.
     */
    @SerializedName("EnjinOauth")
    private User user;

}
