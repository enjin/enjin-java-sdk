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

package com.enjin.platformer.server.data;

import com.enjin.platformer.server.serialization.PacketFactory;
import com.enjin.platformer.server.serialization.PostProcessFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.java_websocket.WebSocket;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PacketProcessor {

    private static final Gson GSON = new GsonBuilder().registerTypeAdapterFactory(new PacketFactory())
                                                      .registerTypeAdapterFactory(new PostProcessFactory())
                                                      .create();

    private Map<PacketType, BiConsumer<WebSocket, ? extends Packet>> delegates = new HashMap();

    public <T extends Packet> void register(PacketType type, BiConsumer<WebSocket, T> delegate) {
        delegates.put(type, delegate);
    }

    public void handle(WebSocket socket, String message) {
        Packet packet = GSON.fromJson(message, (Type) Packet.class);
        BiConsumer<WebSocket, ? extends Packet> delegate = delegates.get(packet.getType());
        handle(socket, packet, (BiConsumer<WebSocket, Packet>) delegate);
    }

    private void handle(WebSocket socket, Packet packet, BiConsumer<WebSocket, Packet> delegate) {
        if (delegate != null)
            delegate.accept(socket, packet);
    }

}
