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

package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    @Getter
    private static App instance;

    private boolean running = true;
    private Config config;
    private PlatformerServer server;

    @SneakyThrows
    private void start() {
        config = Config.load();

        if (!config.validate())
            return;

        server = new PlatformerServer(config);
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

    @SneakyThrows
    public static void main(String... args) {
        instance = new App();
        instance.start();
    }

    @SneakyThrows
    public void exit() {
        running = false;
        server.stop();
    }

}
