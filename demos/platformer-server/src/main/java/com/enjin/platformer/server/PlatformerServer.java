package com.enjin.platformer.server;

import com.enjin.platformer.server.conf.Config;
import com.enjin.platformer.server.data.PacketInHandshake;
import com.enjin.platformer.server.data.PacketProcessor;
import com.enjin.platformer.server.data.PacketType;
import com.enjin.platformer.server.tasks.SdkUpdateTask;
import com.enjin.sdk.TrustedPlatformClient;
import com.enjin.sdk.TrustedPlatformClientBuilder;
import lombok.SneakyThrows;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PlatformerServer extends WebSocketServer {

    private static final long UPDATE_INTERVAL = TimeUnit.HOURS.toMillis(6);

    private final Config config;
    private final PacketProcessor processor;
    private final TrustedPlatformClient sdk;
    private Timer updateTimer;
    private TimerTask updateTask;

    private Map<InetSocketAddress, String> addressToName = new HashMap<>();
    private Map<String, InetSocketAddress> nameToAddress = new HashMap<>();

    public PlatformerServer(Config config) {
        super(config.getAddress());
        this.config = config;
        this.processor = new PacketProcessor();
        this.sdk = new TrustedPlatformClientBuilder().baseUrl(TrustedPlatformClientBuilder.KOVAN)
                                                     .httpLogLevel(Level.BODY)
                                                     .build();
        this.updateTimer = new Timer();
        this.updateTask = new SdkUpdateTask(sdk, config);
        init();
    }

    private void init() {
        registerPacketDelegates();
        updateTimer.schedule(updateTask, 0, UPDATE_INTERVAL);
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
        super.start();
    }

    @Override
    @SneakyThrows
    public void stop() {
        super.stop();
        sdk.close();
        updateTimer.cancel();
    }

    public void onHandshake(WebSocket conn, PacketInHandshake packet) {
        InetSocketAddress addr = conn.getRemoteSocketAddress();
        System.out.println("Handshake Received: " + addr);
        addressToName.put(addr, packet.getName());
        nameToAddress.put(packet.getName(), addr);
    }

}
