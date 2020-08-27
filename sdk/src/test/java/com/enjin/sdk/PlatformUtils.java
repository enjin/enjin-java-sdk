package com.enjin.sdk;

import com.enjin.sdk.models.Notifications;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Pusher;
import com.enjin.sdk.models.PusherOptions;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class PlatformUtils {

    public final Platform KOVAN = createMockPlatform("kovan");
    public final Platform MAIN_NET = createMockPlatform("mainnet");

    @SneakyThrows
    public Platform createMockPlatform(String network) {
        Platform platform = new Platform();

        Class<? extends Platform> c = platform.getClass();
        Field networkField = c.getDeclaredField("network");
        networkField.setAccessible(true);
        networkField.set(platform, network);
        Field notificationsField = c.getDeclaredField("notifications");
        notificationsField.setAccessible(true);
        notificationsField.set(platform, createNotifications());

        return platform;
    }

    @SneakyThrows
    private Notifications createNotifications() {
        Notifications notifications = new Notifications();

        Class<? extends Notifications> c = notifications.getClass();
        Field pusherField = c.getDeclaredField("pusher");
        pusherField.setAccessible(true);
        pusherField.set(notifications, createPusher());

        return notifications;
    }

    @SneakyThrows
    private Pusher createPusher() {
        Pusher pusher = new Pusher();

        Class<? extends Pusher> c = pusher.getClass();
        Field keyField = c.getDeclaredField("key");
        keyField.setAccessible(true);
        keyField.set(pusher, "xyz");
        Field namespaceField = c.getDeclaredField("namespace");
        namespaceField.setAccessible(true);
        namespaceField.set(pusher, "xyz");
        Field optionsField = c.getDeclaredField("options");
        optionsField.setAccessible(true);
        optionsField.set(pusher, createOptions());

        return pusher;
    }

    @SneakyThrows
    private PusherOptions createOptions() {
        PusherOptions options = new PusherOptions();

        Class<? extends PusherOptions> c = options.getClass();
        Field clusterField = c.getDeclaredField("cluster");
        clusterField.setAccessible(true);
        clusterField.set(options, "xyz");
        Field encryptedField = c.getDeclaredField("encrypted");
        encryptedField.setAccessible(true);
        encryptedField.set(options, true);

        return options;
    }

}
