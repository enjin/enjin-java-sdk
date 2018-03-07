package client.service.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.users.AsynchronousUsersService;
import io.enjincoin.sdk.client.service.users.SynchronousUsersService;
import io.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import io.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import io.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import io.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import io.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Calls out to the actual api Will have the disabled annotation in place
 * usually but will be useful for testing the actual api
 */
public class LiveUsersServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousUsersService_GetUsers() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        Response<UserResponseBody[]> usersArray = usersService.getUsersSync();
        assertThat(usersArray).isNotNull();
        assertThat(usersArray.body()).isNotNull();

        for (UserResponseBody user : usersArray.body()) {
            assertThat(user).isNotNull();
            assertThat(user.getId()).isNotNull();
            assertThat(user.getName()).isNotNull();
            assertThat(user.getEmail()).isNotNull();
            assertThat(user.getCreatedAt()).isNotNull();
            assertThat(user.getUpdatedAt()).isNotNull();
           // assertThat(user.getIdentity()).isNotNull();
        }
    }

    @Test
    public void testAsychronousUsersService_GetUsers() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        usersService.getUsersAsync(new Callback<UserResponseBody[]>() {

            @Override
            public void onResponse(Call<UserResponseBody[]> call, Response<UserResponseBody[]> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                UserResponseBody[] usersArray = response.body();
                for (UserResponseBody user : usersArray) {
                    assertThat(user).isNotNull();
                    assertThat(user.getId()).isNotNull();
                    assertThat(user.getName()).isNotNull();
                    assertThat(user.getEmail()).isNotNull();
                    assertThat(user.getCreatedAt()).isNotNull();
                    assertThat(user.getUpdatedAt()).isNotNull();
                    assertThat(user.getIdentity()).isNotNull();
                }
            }

            @Override
            public void onFailure(Call<UserResponseBody[]> call, Throwable t) {
                fail("Test Failed");
            }
        });
    }

    @Test
    public void testSynchronousUsersService_GetUser() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        Response<CreateUserResponseBody> createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.body()).isNotNull();
        assertThat(createUserResponseVO.body().getUser()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getId()).isNotNull();

        Integer userId = createUserResponseVO.body().getUser().getId();

        Response<UserResponseBody> user = usersService.getUserSync(userId);
        assertThat(user).isNotNull();
        assertThat(user.body()).isNotNull();
        assertThat(user.body().getId()).isNotNull();
        assertThat(user.body().getName()).isNotNull();
        assertThat(user.body().getEmail()).isNotNull();
        assertThat(user.body().getCreatedAt()).isNotNull();
        assertThat(user.body().getUpdatedAt()).isNotNull();
        //assertThat(user.body().getIdentity()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_GetUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        usersService.createUserAsync(createUserRequestVO, new Callback<CreateUserResponseBody>() {

            @Override
            public void onResponse(Call<CreateUserResponseBody> call, Response<CreateUserResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();
                assertThat(response.body().getUser()).isNotNull();
                assertThat(response.body().getUser().getId()).isNotNull();

                Integer userId = response.body().getUser().getId();

                usersService.getUserAsync(userId, new Callback<UserResponseBody>() {

                    @Override
                    public void onResponse(Call<UserResponseBody> call, Response<UserResponseBody> response) {
                        UserResponseBody user = response.body();

                        assertThat(user).isNotNull();
                        assertThat(user.getId()).isNotNull();
                        assertThat(user.getName()).isNotNull();
                        assertThat(user.getEmail()).isNotNull();
                        assertThat(user.getCreatedAt()).isNotNull();
                        assertThat(user.getUpdatedAt()).isNotNull();
                        assertThat(user.getIdentity()).isNotNull();
                    }

                    @Override
                    public void onFailure(Call<UserResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

            }

            @Override
            public void onFailure(Call<CreateUserResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }

    @Test
    public void testSynchronousUsersService_CreateUser() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        Response<CreateUserResponseBody> createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.body()).isNotNull();

        assertThat(createUserResponseVO.body().getUser()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getId()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getName()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getEmail()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getUpdatedAt()).isNotNull();
        //assertThat(createUserResponseVO.body().getUser().getIdentity()).isNotNull();

        assertThat(createUserResponseVO.body().getToken()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_CreateUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        usersService.createUserAsync(createUserRequestVO, new Callback<CreateUserResponseBody>() {

            @Override
            public void onResponse(Call<CreateUserResponseBody> call, Response<CreateUserResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateUserResponseBody createUserResponseVO = response.body();
                assertThat(createUserResponseVO.getUser()).isNotNull();
                assertThat(createUserResponseVO.getUser().getId()).isNotNull();
                assertThat(createUserResponseVO.getUser().getName()).isNotNull();
                assertThat(createUserResponseVO.getUser().getEmail()).isNotNull();
                assertThat(createUserResponseVO.getUser().getCreatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getUpdatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getIdentity()).isNotNull();

                assertThat(createUserResponseVO.getToken()).isNotNull();
            }

            @Override
            public void onFailure(Call<CreateUserResponseBody> call, Throwable t) {
                fail("Test Failed");

            }
        });

    }

    @Test
    public void testSynchronousUsersService_UpdateUser() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        Response<CreateUserResponseBody> createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.body()).isNotNull();

        assertThat(createUserResponseVO.body().getUser()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getId()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getName()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getEmail()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getUpdatedAt()).isNotNull();
        //assertThat(createUserResponseVO.body().getUser().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.body().getToken()).isNotNull();

        Integer userId = createUserResponseVO.body().getUser().getId();

        UpdateUserRequestBody updateUserRequest = new UpdateUserRequestBody("UPDATED SDK Testing", "UPDATED email1" + System.currentTimeMillis() + "@test.com", "UPDATEDpassword1");
        Response<UserResponseBody> user = usersService.updateUserSync(userId, updateUserRequest);
        assertThat(user).isNotNull();
        assertThat(user.body()).isNotNull();
        assertThat(user.body().getId()).isNotNull();
        assertThat(user.body().getName()).isNotNull();
        assertThat(user.body().getEmail()).isNotNull();
        assertThat(user.body().getCreatedAt()).isNotNull();
        assertThat(user.body().getUpdatedAt()).isNotNull();
        //assertThat(user.body().getIdentity()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_UpdateUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        usersService.createUserAsync(createUserRequestVO, new Callback<CreateUserResponseBody>() {

            @Override
            public void onResponse(Call<CreateUserResponseBody> call, Response<CreateUserResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateUserResponseBody createUserResponseVO = response.body();
                assertThat(createUserResponseVO.getUser()).isNotNull();
                assertThat(createUserResponseVO.getUser().getId()).isNotNull();
                assertThat(createUserResponseVO.getUser().getName()).isNotNull();
                assertThat(createUserResponseVO.getUser().getEmail()).isNotNull();
                assertThat(createUserResponseVO.getUser().getCreatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getUpdatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getIdentity()).isNotNull();
                assertThat(createUserResponseVO.getToken()).isNotNull();

                Integer userId = createUserResponseVO.getUser().getId();

                UpdateUserRequestBody updateUserRequest = new UpdateUserRequestBody("UPDATED SDK Testing", "UPDATED email1" + System.currentTimeMillis() + "@test.com", "UPDATEDpassword1");
                usersService.updateUserAsync(userId, updateUserRequest, new Callback<UserResponseBody>() {

                    @Override
                    public void onResponse(Call<UserResponseBody> call, Response<UserResponseBody> response) {
                        UserResponseBody user = response.body();

                        assertThat(user).isNotNull();
                        assertThat(user.getId()).isNotNull();
                        assertThat(user.getName()).isNotNull();
                        assertThat(user.getEmail()).isNotNull();
                        assertThat(user.getCreatedAt()).isNotNull();
                        assertThat(user.getUpdatedAt()).isNotNull();
                        assertThat(user.getIdentity()).isNotNull();
                    }

                    @Override
                    public void onFailure(Call<UserResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

            }

            @Override
            public void onFailure(Call<CreateUserResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }

    @Test
    public void testSynchronousUsersService_LoginUser() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        Response<CreateUserResponseBody> createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.body().getUser()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getId()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getName()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getEmail()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.body().getUser().getUpdatedAt()).isNotNull();
        //assertThat(createUserResponseVO.body().getUser().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.body().getToken()).isNotNull();

        String email = createUserResponseVO.body().getUser().getEmail();
        String password = createUserRequestVO.getPassword();
        Integer appId = createUserResponseVO.body().getUser().getId();

        Response<LoginUserResponseBody> loginUserResponseVO = usersService.loginUserSync(email, password, appId);
        assertThat(loginUserResponseVO).isNotNull();
        assertThat(loginUserResponseVO.body()).isNotNull();
        assertThat(loginUserResponseVO.body().getIdentity()).isNotNull();
        assertThat(loginUserResponseVO.body().getToken()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_LoginUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestBody createUserRequestVO = new CreateUserRequestBody(1, "SDK Testing", "email1" + System.currentTimeMillis() + "@test.com", "password1");
        usersService.createUserAsync(createUserRequestVO, new Callback<CreateUserResponseBody>() {

            @Override
            public void onResponse(Call<CreateUserResponseBody> call, Response<CreateUserResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateUserResponseBody createUserResponseVO = response.body();
                assertThat(createUserResponseVO.getUser()).isNotNull();
                assertThat(createUserResponseVO.getUser().getId()).isNotNull();
                assertThat(createUserResponseVO.getUser().getName()).isNotNull();
                assertThat(createUserResponseVO.getUser().getEmail()).isNotNull();
                assertThat(createUserResponseVO.getUser().getCreatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getUpdatedAt()).isNotNull();
                assertThat(createUserResponseVO.getUser().getIdentity()).isNotNull();
                assertThat(createUserResponseVO.getToken()).isNotNull();

                String email = createUserResponseVO.getUser().getEmail();
                String password = createUserRequestVO.getPassword();
                Integer appId = createUserResponseVO.getUser().getId();

                usersService.loginUserAsync(email, password, appId, new Callback<LoginUserResponseBody>() {

                    @Override
                    public void onResponse(Call<LoginUserResponseBody> call, Response<LoginUserResponseBody> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();

                        LoginUserResponseBody loginUserResponseVO = response.body();
                        assertThat(loginUserResponseVO).isNotNull();
                        assertThat(loginUserResponseVO.getIdentity()).isNotNull();
                        assertThat(loginUserResponseVO.getToken()).isNotNull();
                    }

                    @Override
                    public void onFailure(Call<LoginUserResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }

                });
            }

            @Override
            public void onFailure(Call<CreateUserResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }

    @Test
    public void testSynchronousUsersService_LoginUserFailed() throws IOException {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        String email = System.currentTimeMillis() + "email" + System.currentTimeMillis();
        String password = System.currentTimeMillis() + "password" + System.currentTimeMillis();
        Integer appId = 1;

        Response<LoginUserResponseBody> loginUserResponseVO = usersService.loginUserSync(email, password, appId);
        assertThat(loginUserResponseVO).isNotNull();
        assertThat(loginUserResponseVO.body()).isNull();
    }

    @Test
    public void testAsychronousUsersService_LoginUserFailed() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        String email = System.currentTimeMillis() + "email" + System.currentTimeMillis();
        String password = System.currentTimeMillis() + "password" + System.currentTimeMillis();
        Integer appId = 1;

        usersService.loginUserAsync(email, password, appId, new Callback<LoginUserResponseBody>() {

            @Override
            public void onResponse(Call<LoginUserResponseBody> call, Response<LoginUserResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                LoginUserResponseBody loginUserResponseVO = response.body();
                assertThat(loginUserResponseVO).isNull();
            }

            @Override
            public void onFailure(Call<LoginUserResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });

    }
}
