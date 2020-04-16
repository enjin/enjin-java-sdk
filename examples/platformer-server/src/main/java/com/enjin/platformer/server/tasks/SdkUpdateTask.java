package com.enjin.platformer.server.tasks;

import com.enjin.platformer.server.App;
import com.enjin.platformer.server.conf.Config;
import com.enjin.sdk.TrustedPlatformClient;

import java.util.TimerTask;

public class SdkUpdateTask extends TimerTask {

    private TrustedPlatformClient sdk;
    private Config config;

    public SdkUpdateTask(TrustedPlatformClient sdk, Config config) {
        this.sdk = sdk;
        this.config = config;
    }

    @Override
    public void run() {
        this.sdk.authAppSync(config.getAppId(), config.getAppSecret());

        if (!sdk.isAuthenticated())
            App.getInstance().exit();
    }

}
