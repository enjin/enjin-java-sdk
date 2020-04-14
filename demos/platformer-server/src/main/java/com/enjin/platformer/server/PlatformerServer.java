package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
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

    private final Config config;
    private final SdkManager sdkManager;
    private final PacketProcessor processor;

    private Map<InetSocketAddress, String> addressToName = new HashMap<>();
    private Map<String, InetSocketAddress> nameToAddress = new HashMap<>();

    public PlatformerServer(Config config) {
        super(config.getAddress());
        this.config = config;
        this.sdkManager = new SdkManager(config);
        this.processor = new PacketProcessor();
        registerPacketDelegates();
    }

    private void registerPacketDelegates() {
        processor.register(PacketType.HANDSHAKE, this::onHandshake);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("Connection Established: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        InetSocketAddress addr = conn.getRemoteSocketAddress();
        System.out.println("Connection Closed: " + addr);
        if (addressToName.containsKey(addr))
            nameToAddress.remove(addressToName.remove(addr));
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

    @Override
    public void start() {
        sdkManager.start();
        super.start();
    }

    @Override
    public void stop(int timeout) throws InterruptedException {
        super.stop(timeout);
        sdkManager.setRunning(false);
    }

    public void onHandshake(WebSocket conn, PacketInHandshake packet) {
        InetSocketAddress addr = conn.getRemoteSocketAddress();
        System.out.println("Handshake Received: " + addr);
        addressToName.put(addr, packet.getName());
        nameToAddress.put(packet.getName(), addr);
    }

}
