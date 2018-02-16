package io.enjincoin.sdk.client.service.platform;

import io.enjincoin.sdk.client.service.platform.AsynchronousPlatformService;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;

public interface PlatformService extends SynchronousPlatformService, AsynchronousPlatformService {
}
