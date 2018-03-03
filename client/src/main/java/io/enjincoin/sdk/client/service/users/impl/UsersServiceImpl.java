package io.enjincoin.sdk.client.service.users.impl;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.StringUtils;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.users.UsersService;
import io.enjincoin.sdk.client.util.GsonUtils;
import io.enjincoin.sdk.client.util.JsonUtils;
import io.enjincoin.sdk.client.vo.user.CreateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.CreateUserResponseVO;
import io.enjincoin.sdk.client.vo.user.LoginUserResponseVO;
import io.enjincoin.sdk.client.vo.user.UpdateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.UserResponseVO;

/**
 * <p>
 *  implementation of UsersService.
 * </p>
 */
public class UsersServiceImpl extends BaseService implements UsersService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(UsersServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public UsersServiceImpl(final Config config) {
        super(config);
    }


    /**
     * Method to get all users
     * @return UserResponseVO[]
     */
    @Override
    public UserResponseVO[] getUsersSync() {
        UserResponseVO[] getUsersResponseArray = null;

        // Get the users url and append the filter
        String getUsersUrl = getUsersUrl();

        String responseJsonString = performGetCall(getUsersUrl);

        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the getUsers call");
            return getUsersResponseArray;
        }
        getUsersResponseArray = (UserResponseVO[]) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, UserResponseVO[].class);

        return getUsersResponseArray;
    }
    /**
     * Method to get the user for a userId
     * @param userId
     * @return UserResponseVO
     */
    @Override
    public UserResponseVO getUserSync(Integer userId) {
        UserResponseVO userResponse = null;

        if (ObjectUtils.isNull(userId)) {
            LOGGER.warning("Users.get userId is null.");
            return userResponse;
        }

        // Get the users url and append the id
        String getUserUrl = String.format("%s/%d", getUsersUrl(), userId);

        String responseJsonString = performGetCall(getUserUrl);

        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the getUsers call");
            return userResponse;
        }
        userResponse = (UserResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, UserResponseVO.class);

        return userResponse;
    }

    /**
     * Method to create a user
     * @param createUserRequestVO
     * @return CreateUserResponseVO
     */
    @Override
    public CreateUserResponseVO createUserSync(CreateUserRequestVO createUserRequestVO) {
        CreateUserResponseVO createUserResponseVO = null;

        if (ObjectUtils.isNull(createUserRequestVO)) {
            LOGGER.warning("Users.create createUserRequestVO is null.");
            return createUserResponseVO;
        }

        //Convert the request object to json
        String requestJsonString = JsonUtils.convertObjectToJson(GsonUtils.GSON, createUserRequestVO);
        if (StringUtils.isEmpty(requestJsonString)) {
            LOGGER.warning("Users.create failed to convert request object to json.");
        }
         // Get the create user url
        String createUserUrl = getUsersUrl();

        String responseJsonString = performPostCall(createUserUrl, requestJsonString);

        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the createUser call");
            return createUserResponseVO;
        }
        createUserResponseVO = (CreateUserResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, CreateUserResponseVO.class);

        return createUserResponseVO;
    }

    /**
     * Method to update a user.
     * @param updateUserRequest - details to update to
     * @param userId - the user to update
     * @return
     */
    @Override
    public UserResponseVO updateUserSync(UpdateUserRequestVO updateUserRequest, Integer userId) {
        UserResponseVO updateUserResponseVO = null;

        if (ObjectUtils.isNull(updateUserRequest) || ObjectUtils.isNull(userId)) {
            LOGGER.warning("Users.update updateUserRequest or userId is null.");
            return updateUserResponseVO;
        }

        //Convert the request object to json
        String requestJsonString = JsonUtils.convertObjectToJson(GsonUtils.GSON, updateUserRequest);
        if (StringUtils.isEmpty(requestJsonString)) {
            LOGGER.warning("Users.update failed to convert request object to json.");
        }
        // Get the updated users url and append the id
        String getUpdateUserUrl = String.format("%s/%d", getUsersUrl(), userId);

        String responseJsonString = performPutCall(getUpdateUserUrl, requestJsonString);

        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the updateUser call");
            return updateUserResponseVO;
        }
        updateUserResponseVO = (UserResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, UserResponseVO.class);

        return updateUserResponseVO;
    }

    /**
     * Method to login a user
     * @param email address to use
     * @param password to use
     * @param appId to use
     * @return
     */
    @Override
    public LoginUserResponseVO loginUserSync(String email, String password, Integer appId) {
        LoginUserResponseVO loginUserResponseVO = null;

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || ObjectUtils.isNull(appId)) {
            LOGGER.warning("Users.login email, password or appId is null or empty");
            return loginUserResponseVO;
        }

        // Get the user login url
        String getUserLoginUrl = String.format("%s?email=%s&password=%s&app_id=%s", getUserLoginUrl(), email, password, appId);

        String responseJsonString = performPutCall(getUserLoginUrl);

        if (StringUtils.isEmpty(responseJsonString)) {
            LOGGER.warning("No response returned from the loginUser call");
            return loginUserResponseVO;
        }

        loginUserResponseVO = (LoginUserResponseVO) JsonUtils.convertJsonToObject(GsonUtils.GSON, responseJsonString, LoginUserResponseVO.class);

        return loginUserResponseVO;
    }

    @Override
    public CompletableFuture<UserResponseVO[]> getUsersAsync() {
        return CompletableFuture.supplyAsync(() -> this.getUsersSync(), this.getExecutorService());
    }
    @Override
    public CompletableFuture<UserResponseVO> getUserAsync(Integer userId) {
        return CompletableFuture.supplyAsync(() -> this.getUserSync(userId), this.getExecutorService());
    }
    @Override
    public CompletableFuture<CreateUserResponseVO> createUserAsync(CreateUserRequestVO createUserRequestVO) {
        return CompletableFuture.supplyAsync(() -> this.createUserSync(createUserRequestVO), this.getExecutorService());
    }
    @Override
    public CompletableFuture<UserResponseVO> updateUserAsync(UpdateUserRequestVO updateUserRequestVO, Integer userId) {
        return CompletableFuture.supplyAsync(() -> this.updateUserSync(updateUserRequestVO, userId), this.getExecutorService());
    }
    @Override
    public CompletableFuture<LoginUserResponseVO> loginUserAsync(String email, String password, Integer appId) {
        return CompletableFuture.supplyAsync(() -> this.loginUserSync(email, password, appId), this.getExecutorService());
    }
}
