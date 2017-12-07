package com.enjin.coin.sdk;

import org.junit.Ignore;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;

/**
 * <p>Utility class used when running test.</p>
 *
 */
@Ignore
public class BaseTestHelper {

    /**
     * Method to get the endjinConfig
     * @return
     */
    public static Config getEnjinConfig() {
        Notification notification = ImmutableNotification.builder()
                .setActivityTimeout(4000l)
                .setAppChannel("testChannel")
                .setAppKey("505648a2c40940a286e2")
                .setCluster("eu")
                .build();
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        Config enjinConfig = ImmutableConfig.builder()
                .setInTestMode(false)
                .setNotification(notification)
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();

        return enjinConfig;
    }

}
