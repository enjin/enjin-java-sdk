package com.enjin.platformer.server;

import com.enjin.platformer.server.data.PacketInHandshake;
import com.enjin.platformer.server.data.PacketProcessor;
import com.enjin.platformer.server.data.PacketType;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class PlatformerServer extends WebSocketServer {

    private final PacketProcessor processor = new PacketProcessor();

    private Map<InetSocketAddress, String> addressToName = new HashMap<>();
    private Map<String, InetSocketAddress> nameToAddress = new HashMap<>();

    public PlatformerServer(InetSocketAddress address) {
        super(address);
        processor.register(PacketType.HANDSHAKE, this::onHandshake);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("Connection Established: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connection Closed: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        processor.handle(conn, message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("WebSocket Server Started!");
    }

    public void onHandshake(WebSocket socket, PacketInHandshake packet) {
        System.out.println("Handshake Received: " + socket.getRemoteSocketAddress());
    }

}
