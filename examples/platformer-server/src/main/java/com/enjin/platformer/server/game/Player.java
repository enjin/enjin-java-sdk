package com.enjin.platformer.server.game;


import com.enjin.platformer.server.PlatformerServer;
import com.enjin.platformer.server.data.PacketOutAuthenticated;
import com.enjin.platformer.server.websocket.Peer;
import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.project.mutations.CreatePlayer;
import com.enjin.sdk.schemas.project.queries.AuthPlayer;
import lombok.Getter;

public class Player {

    private static final int NOT_FOUND = 401;

    @Getter
    private String name;
    private transient Peer peer;
    private transient PlatformerServer server;
    private transient AccessToken accessToken;

    public Player(String name, Peer peer, PlatformerServer server) {
        this.name = name;
        this.peer = peer;
        this.server = server;
    }

    public void auth() {
        AuthPlayer request = new AuthPlayer().id(name);
        server.getSdk().authPlayer(request, this::onAuth);
    }

    private void register() {
        CreatePlayer request = new CreatePlayer().id(name);
        server.getSdk().createPlayer(request, this::onAuth);
    }

    private void onAuth(HttpResponse<GraphQLResponse<AccessToken>> httpResponse) {
        if (httpResponse.isEmpty())
            return;

        GraphQLResponse<AccessToken> graphQLResponse = httpResponse.body();
        if (graphQLResponse.hasErrors()) {
            for (GraphQLError error : graphQLResponse.getErrors()) {
                if (error.getCode() == NOT_FOUND) {
                    register();
                    break;
                }
            }

            return;
        }

        accessToken = graphQLResponse.getData();
        peer.send(new PacketOutAuthenticated(accessToken,
                                             server.getConfig().getAppUuid(),
                                             server.getConfig().getAssets()));
    }

}
