package io.enjincoin.sdk.client.service.legacy.users;

import java.util.concurrent.CompletableFuture;

import io.enjincoin.sdk.client.vo.user.CreateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.CreateUserResponseVO;
import io.enjincoin.sdk.client.vo.user.LoginUserResponseVO;
import io.enjincoin.sdk.client.vo.user.UpdateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.UserResponseVO;

/**
 * Users service interface.
 */
public interface AsynchronousUsersService {

    /**
     * Method to get all users
     * @return UserResponseVO[]
     */
    CompletableFuture<UserResponseVO[]> getUsersAsync();

    /**
     * Method to get the user for a userId
     * @param userId
     * @return UserResponseVO
     */
    CompletableFuture<UserResponseVO> getUserAsync(Integer userId);

    /**
     * Method to create a user
     * @param createUserRequestVO
     * @return CreateUserResponseVO
     */
    CompletableFuture<CreateUserResponseVO> createUserAsync(CreateUserRequestVO createUserRequestVO);

    /**
     * Method to update a user.
     * @param updateUserRequest - details to update to
     * @param userId - the user to update
     * @return
     */
    CompletableFuture<UserResponseVO> updateUserAsync(UpdateUserRequestVO updateUserRequest, Integer userId);

    /**
     * Method to login a user
     * @param email address to use
     * @param password to use
     * @param appId to use
     * @return
     */
    CompletableFuture<LoginUserResponseVO> loginUserAsync(String email, String password, Integer appId);
}
