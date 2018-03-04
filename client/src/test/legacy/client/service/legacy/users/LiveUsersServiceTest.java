package io.enjincoin.sdk.client.service.legacy.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.vo.user.CreateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.CreateUserResponseVO;
import io.enjincoin.sdk.client.vo.user.LoginUserResponseVO;
import io.enjincoin.sdk.client.vo.user.UpdateUserRequestVO;
import io.enjincoin.sdk.client.vo.user.UserResponseVO;

/**
 * Calls out to the actual api Will have the disabled annotation in place
 * usually but will be useful for testing the actual api
 */
public class LiveUsersServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousUsersService_GetUsers() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        UserResponseVO[] usersArray = usersService.getUsersSync();
        assertThat(usersArray).isNotNull();

        for (UserResponseVO user : usersArray) {
            assertThat(user).isNotNull();
            assertThat(user.getId()).isNotNull();
            assertThat(user.getName()).isNotNull();
            assertThat(user.getEmail()).isNotNull();
            assertThat(user.getCreatedAt()).isNotNull();
            assertThat(user.getUpdatedAt()).isNotNull();
            assertThat(user.getIdentity()).isNotNull();
        }
    }

    @Test
    public void testAsychronousUsersService_GetUsers() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CompletableFuture<UserResponseVO[]> usersArrayCf = usersService.getUsersAsync();
        assertThat(usersArrayCf).isNotNull();
        assertThat(usersArrayCf.get()).isNotNull();

        UserResponseVO[] usersArray = usersArrayCf.get();
        for (UserResponseVO user : usersArray) {
            assertThat(user).isNotNull();
            assertThat(user.getId()).isNotNull();
            assertThat(user.getName()).isNotNull();
            assertThat(user.getEmail()).isNotNull();
            assertThat(user.getCreatedAt()).isNotNull();
            assertThat(user.getUpdatedAt()).isNotNull();
            assertThat(user.getIdentity()).isNotNull();
        }
    }

    @Test
    public void testSynchronousUsersService_GetUser() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CreateUserResponseVO createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();

        Integer userId = createUserResponseVO.getUser().get().getId().get();

        UserResponseVO user = usersService.getUserSync(userId);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getIdentity()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_GetUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CompletableFuture<CreateUserResponseVO> createUserResponseVOCf = usersService.createUserAsync(createUserRequestVO);
        assertThat(createUserResponseVOCf).isNotNull();
        assertThat(createUserResponseVOCf.get()).isNotNull();
        assertThat(createUserResponseVOCf.get().getUser()).isNotNull();
        assertThat(createUserResponseVOCf.get().getUser().get().getId()).isNotNull();

        Integer userId = createUserResponseVOCf.get().getUser().get().getId().get();

        CompletableFuture<UserResponseVO> userCf = usersService.getUserAsync(userId);
        UserResponseVO user = userCf.get();

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getIdentity()).isNotNull();

    }

    @Test
    public void testSynchronousUsersService_CreateUser() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CreateUserResponseVO createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();

        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();

        assertThat(createUserResponseVO.getToken()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_CreateUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"),
                Optional.of("password1"));
        CompletableFuture<CreateUserResponseVO> createUserResponseVOCf = usersService.createUserAsync(createUserRequestVO);
        assertThat(createUserResponseVOCf).isNotNull();
        assertThat(createUserResponseVOCf.get()).isNotNull();

        CreateUserResponseVO createUserResponseVO = createUserResponseVOCf.get();
        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();

        assertThat(createUserResponseVO.getToken()).isNotNull();
    }

    @Test
    public void testSynchronousUsersService_UpdateUser() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CreateUserResponseVO createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();

        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.getToken()).isNotNull();

        Integer userId = createUserResponseVO.getUser().get().getId().get();

        UpdateUserRequestVO updateUserRequest = new UpdateUserRequestVO(Optional.of("UPDATED SDK Testing"), Optional.of("UPDATED email1" + System.currentTimeMillis() + "@test.com"), Optional.of("UPDATEDpassword1"));
        UserResponseVO user = usersService.updateUserSync(updateUserRequest, userId);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getIdentity()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_UpdateUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"),
                Optional.of("password1"));
        CompletableFuture<CreateUserResponseVO> createUserResponseVOCf = usersService.createUserAsync(createUserRequestVO);
        assertThat(createUserResponseVOCf).isNotNull();
        assertThat(createUserResponseVOCf.get()).isNotNull();

        CreateUserResponseVO createUserResponseVO = createUserResponseVOCf.get();
        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.getToken()).isNotNull();

        Integer userId = createUserResponseVO.getUser().get().getId().get();

        UpdateUserRequestVO updateUserRequest = new UpdateUserRequestVO(Optional.of("UPDATED SDK Testing"), Optional.of("UPDATED email1" + System.currentTimeMillis() + "@test.com"), Optional.of("UPDATEDpassword1"));
        CompletableFuture<UserResponseVO> userCf = usersService.updateUserAsync(updateUserRequest, userId);
        UserResponseVO user = userCf.get();

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getIdentity()).isNotNull();
    }

    @Test
    public void testSynchronousUsersService_LoginUser() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CreateUserResponseVO createUserResponseVO = usersService.createUserSync(createUserRequestVO);
        assertThat(createUserResponseVO).isNotNull();
        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.getToken()).isNotNull();

        String email = createUserResponseVO.getUser().get().getEmail().get();
        String password = createUserRequestVO.getPassword().get();
        Integer appId = createUserResponseVO.getUser().get().getId().get();

        LoginUserResponseVO loginUserResponseVO = usersService.loginUserSync(email, password, appId);

        assertThat(loginUserResponseVO).isNotNull();
        assertThat(loginUserResponseVO.getIdentity()).isNotNull();
        assertThat(loginUserResponseVO.getToken()).isNotNull();
    }

    @Test
    public void testAsychronousUsersService_LoginUser() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        CreateUserRequestVO createUserRequestVO = new CreateUserRequestVO(Optional.of(1), Optional.of("SDK Testing"), Optional.of("email1" + System.currentTimeMillis() + "@test.com"), Optional.of("password1"));
        CompletableFuture<CreateUserResponseVO> createUserResponseVOCf = usersService.createUserAsync(createUserRequestVO);
        assertThat(createUserResponseVOCf).isNotNull();
        assertThat(createUserResponseVOCf.get()).isNotNull();

        CreateUserResponseVO createUserResponseVO = createUserResponseVOCf.get();
        assertThat(createUserResponseVO.getUser()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getId()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getName()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getEmail()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getCreatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getUpdatedAt()).isNotNull();
        assertThat(createUserResponseVO.getUser().get().getIdentity()).isNotNull();
        assertThat(createUserResponseVO.getToken()).isNotNull();

        String email = createUserResponseVO.getUser().get().getEmail().get();
        String password = createUserRequestVO.getPassword().get();
        Integer appId = createUserResponseVO.getUser().get().getId().get();

        CompletableFuture<LoginUserResponseVO> loginUserResponseVOCf = usersService.loginUserAsync(email, password, appId);
        assertThat(loginUserResponseVOCf).isNotNull();
        assertThat(loginUserResponseVOCf.get()).isNotNull();

        LoginUserResponseVO loginUserResponseVO = loginUserResponseVOCf.get();
        assertThat(loginUserResponseVO).isNotNull();
        assertThat(loginUserResponseVO.getIdentity()).isNotNull();
        assertThat(loginUserResponseVO.getToken()).isNotNull();
    }

    @Test
    public void testSynchronousUsersService_LoginUserFailed() {
        SynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        String email = System.currentTimeMillis() + "email" + System.currentTimeMillis();
        String password = System.currentTimeMillis() + "password" + System.currentTimeMillis();
        Integer appId = 1;

        LoginUserResponseVO loginUserResponseVO = usersService.loginUserSync(email, password, appId);
        assertThat(loginUserResponseVO).isNull();
    }

    @Test
    public void testAsychronousUsersService_LoginUserFailed() throws InterruptedException, ExecutionException {
        AsynchronousUsersService usersService = this.client.getUsersService();
        assertThat(usersService).isNotNull();

        String email = System.currentTimeMillis() + "email" + System.currentTimeMillis();
        String password = System.currentTimeMillis() + "password" + System.currentTimeMillis();
        Integer appId = 1;

        CompletableFuture<LoginUserResponseVO> loginUserResponseVOCf = usersService.loginUserAsync(email, password, appId);
        assertThat(loginUserResponseVOCf).isNotNull();
        assertThat(loginUserResponseVOCf.get()).isNull();

        LoginUserResponseVO loginUserResponseVO = loginUserResponseVOCf.get();
        assertThat(loginUserResponseVO).isNull();
    }
}
