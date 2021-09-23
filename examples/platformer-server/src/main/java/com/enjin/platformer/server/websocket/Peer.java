/* Copyright 2021 Enjin Pte Ltd.
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

package com.enjin.platformer.server.websocket;

import com.enjin.platformer.server.data.Packet;
import lombok.Getter;
import org.java_websocket.WebSocket;

@Getter
public class Peer {

    private static int NEXT_ID = 0;

    private final WebSocket socket;
    private final int id;

    public Peer(WebSocket socket) {
        this.socket = socket;
        this.id = NEXT_ID++;
        socket.setAttachment(this);
    }

    public void send(Packet packet) {
        socket.send(packet.toString());
    }

}
