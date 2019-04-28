package com.enjin.enjincoin.sdk.model.service.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

/**
 * The result of a get users request.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
@Getter
public class GetUsersResult {

    /**
     * The users that match the query parameters.
     *
     * @return a list of users that match the query parameters.
     */
    @SerializedName("EnjinUsers")
    private List<User> users;

}
