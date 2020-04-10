package com.enjin.platformer.server;

public class PlatformerServer {

    private static PlatformerServer server;

    private boolean running = true;

    private int start() {
        while (running) {
            // Main Loop
        }

        return 0;
    }

    public static void main(String... args) {
        server = new PlatformerServer();
        int status = server.start();
        System.exit(status);
    }

    public static void exit() {
        server.running = false;
    }

}
