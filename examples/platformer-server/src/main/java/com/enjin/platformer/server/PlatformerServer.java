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
import com.enjin.platformer.server.data.PacketInHandshake;
import com.enjin.platformer.server.data.PacketInSendAsset;
import com.enjin.platformer.server.data.PacketProcessor;
import com.enjin.platformer.server.data.PacketType;
import com.enjin.platformer.server.game.Player;
import com.enjin.platformer.server.tasks.SdkUpdateTask;
import com.enjin.platformer.server.websocket.Peer;
import com.enjin.sdk.EnjinHosts;
import com.enjin.sdk.ProjectClient;
import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.schemas.project.mutations.SendAsset;
import lombok.Getter;
import lombok.SneakyThrows;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PlatformerServer extends WebSocketServer {

    private static final long UPDATE_INTERVAL = TimeUnit.HOURS.toMillis(6);

    @Getter
    private final Config config;
    private final PacketProcessor processor;
    @Getter
    private final ProjectClient sdk;

    private Timer updateTimer;
    private TimerTask updateTask;
    private Map<Integer, Peer> peers;
    @Getter
    private Map<Integer, Player> players;

    public PlatformerServer(Config config) {
        super(config.getAddress());
        this.config = config;
        this.processor = new PacketProcessor();
        this.sdk = new ProjectClient(EnjinHosts.KOVAN, true);
        this.updateTimer = new Timer();
        this.updateTask = new SdkUpdateTask(sdk, config);
        this.peers = new HashMap<>();
        this.players = new HashMap<>();
        init();
    }

    private void init() {
        registerPacketDelegates();
        updateTimer.schedule(updateTask, 0, UPDATE_INTERVAL);
    }

    private void registerPacketDelegates() {
        processor.register(PacketType.HANDSHAKE, this::onHandshake);
        processor.register(PacketType.SEND_ASSET, this::onSendAsset);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        Peer peer = new Peer(conn);
        peers.put(peer.getId(), peer);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        Optional<Peer> attachment = Optional.ofNullable(conn.getAttachment());
        attachment.ifPresent(peer -> {
            System.out.printf("Connection With Peer %s Closed!\n", peer.getId());
            peers.remove(peer.getId());
            players.remove(peer.getId());
        });
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
    @SneakyThrows
    public void stop() {
        super.stop();
        sdk.close();
        updateTimer.cancel();
    }

    private void onHandshake(WebSocket conn, PacketInHandshake packet) {
        Optional<Peer> attachment = Optional.ofNullable(conn.getAttachment());
        attachment.ifPresent(peer -> {
            System.out.println(String.format("Received Handshake From Peer %s", peer.getId()));
            Player player = new Player(packet.getName(), peer, this);
            players.put(peer.getId(), player);
            player.auth();
        });
    }

    private void onSendAsset(WebSocket conn, PacketInSendAsset packet) {
        Optional<Peer> attachment = Optional.ofNullable(conn.getAttachment());
        attachment.ifPresent(peer -> {
            SendAsset request = new SendAsset().assetId(packet.getAsset())
                                               .value(String.valueOf(packet.getAmount()))
                                               .ethAddress(config.getDevWallet())
                                               .recipientAddress(packet.getRecipientWallet());
            sdk.sendAsset(request, this::onSendAssetComplete);
        });
    }

    private void onSendAssetComplete(HttpResponse<GraphQLResponse<Request>> httpResponse) {
        if (httpResponse.isSuccess() && httpResponse.body().hasErrors()) {
            for (GraphQLError error : httpResponse.body().getErrors())
                System.out.println(String.format("Error %s: %s", error.getCode(), error.getMessage()));
        }
    }

}
