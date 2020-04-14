package com.enjin.platformer.server.conf;

import com.enjin.platformer.server.serialization.PostProcessFactory;
import com.enjin.platformer.server.serialization.PostProcessable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetSocketAddress;

public class Config implements PostProcessable {

    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;
    private static final int MIN_APP_ID = 1;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
                                                      .registerTypeAdapterFactory(new PostProcessFactory())
                                                      .create();
    private static final File CONFIG_DIR = new File("./");
    private static final File CONFIG_FILE = new File(CONFIG_DIR, "config.json");

    private String host = "0.0.0.0";
    private int port = 11011;
    @Getter
    private int appId = -1;
    @Getter
    private String appSecret = "";

    @Getter
    private transient InetSocketAddress address;

    @Override
    public void process() {
        address = new InetSocketAddress(host, port);
    }

    @SneakyThrows
    public void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE, false)) {
            GSON.toJson(this, writer);
        }
    }

    @SneakyThrows
    public static Config load() {
        if (!CONFIG_FILE.exists()) {
            CONFIG_DIR.mkdirs();
            new Config().save();
        }

        Config cfg;
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            cfg = GSON.fromJson(reader, Config.class);
        }

        return cfg;
    }

    public boolean validate() {
        boolean validPort = validatePort();
        boolean validAppId = appId >= MIN_APP_ID;
        boolean validAppSecret = !appSecret.isEmpty();

        if (!validPort)
            System.out.println(String.format("Port must be a number from %s through %s.", MIN_PORT, MAX_PORT));

        if (!validAppId)
            System.out.println(String.format("App ID must be a number greater than or equal to %s.", MIN_APP_ID));

        if (!validAppSecret)
            System.out.println("App secret must be provided.");

        return validPort && validAppId && validAppSecret;
    }

    public boolean validatePort() {
        return port >= MIN_PORT && port <= MAX_PORT;
    }
}
