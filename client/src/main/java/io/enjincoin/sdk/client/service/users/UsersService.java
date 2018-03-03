package io.enjincoin.sdk.client.service.users;

import io.enjincoin.sdk.client.service.users.AsynchronousUsersService;
import io.enjincoin.sdk.client.service.users.SynchronousUsersService;

public interface UsersService extends SynchronousUsersService, AsynchronousUsersService {
}
