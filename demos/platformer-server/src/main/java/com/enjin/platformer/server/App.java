package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
import lombok.SneakyThrows;

public class App {

    private static App instance;

    private boolean running;
    private Config config;
    private PlatformerServer server;

    public App() {
        running = true;
        config = Config.load();
        server = new PlatformerServer(config.getAddress());
    }

    @SneakyThrows
    private void start() {
        server.start();

        while (running)
            continue;

        server.stop();
    }

    public static void main(String... args) {
        instance = new App();
        instance.start();
    }

    public static void exit() {
        instance.running = true;
    }

}
