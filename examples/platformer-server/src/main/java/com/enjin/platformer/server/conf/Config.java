/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.platformer.server.conf;

import com.enjin.platformer.server.game.Asset;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config implements PostProcessable {

    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;
    private static final int MIN_APP_ID = 1;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
                                                      .registerTypeAdapterFactory(new PostProcessFactory())
                                                      .create();
    private static final File CONFIG_DIR = new File("./");
    private static final File CONFIG_FILE = new File(CONFIG_DIR, "config.json");
    private static final List<String> ASSET_KEYS = Arrays.asList("coin", "crown", "key", "health_upgrade");

    private String host = "0.0.0.0";
    private int port = 11011;
    @Getter
    private String appUuid = "";
    @Getter
    private String appSecret = "";
    private Map<String, Asset> assets = getAssets();
    @Getter
    private String devWallet = "";

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
        boolean validAppUuid = !(appUuid == null || appUuid.isEmpty());
        boolean validAppSecret = !appSecret.isEmpty();
        boolean validDevWallet = !(devWallet == null || devWallet.isEmpty());
        boolean validAssets = validateAssets();

        if (!validPort)
            System.out.println(String.format("Port must be a number from %s through %s.", MIN_PORT, MAX_PORT));

        if (!validAppUuid)
            System.out.println("App uuid must be provided.");

        if (!validAppSecret)
            System.out.println("App secret must be provided.");

        if (!validDevWallet)
            System.out.println("Developer wallet must be set.");

        return validPort && validAppUuid && validAppSecret && validDevWallet && validAssets;
    }

    public boolean validatePort() {
        return port >= MIN_PORT && port <= MAX_PORT;
    }

    public boolean validateAssets() {
        boolean keysValid = ASSET_KEYS.stream().allMatch(assets::containsKey);
        boolean idsValid = assets.values().stream().allMatch(t -> !(t.getId() == null || t.getId().isEmpty()));

        if (!keysValid)
            System.out.println(String.format("One of the following assets is undefined: %s",
                                             String.join(",", ASSET_KEYS)));

        return keysValid && idsValid;
    }

    public Map<String, Asset> getAssets() {
        if (assets == null) {
            assets = new HashMap<>();
            for (String key : ASSET_KEYS)
                assets.put(key, new Asset());
        }

        return assets;
    }

}
