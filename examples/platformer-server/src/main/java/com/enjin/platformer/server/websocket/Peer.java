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
