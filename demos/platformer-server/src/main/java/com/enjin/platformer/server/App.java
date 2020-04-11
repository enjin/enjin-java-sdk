package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    @Getter
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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (running) {
                String in = reader.readLine();
                if (in.equals("exit") || in.equals("stop")) {
                    exit();
                }
            }
        }
    }

    public static void main(String... args) {
        instance = new App();
        instance.start();
    }

    @SneakyThrows
    public void exit() {
        running = false;
        server.stop(1000);
    }

}
