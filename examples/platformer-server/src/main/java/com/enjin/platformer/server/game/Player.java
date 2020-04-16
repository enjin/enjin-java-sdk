package com.enjin.platformer.server.game;


import com.enjin.platformer.server.PlatformerServer;
import com.enjin.platformer.server.data.PacketOutAuthenticated;
import com.enjin.platformer.server.websocket.Peer;
import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.user.AuthPlayer;
import com.enjin.sdk.models.user.CreateUser;
import com.enjin.sdk.models.user.User;
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
        AuthPlayer input = new AuthPlayer().id(name);
        server.getSdk().getUserService().authUserAsync(input, this::onAuth);
    }

    private void register() {
        CreateUser input = new CreateUser().name(name);
        server.getSdk().getUserService().createUserAsync(input, this::onRegister);
    }

    private void onAuth(HttpResponse<GraphQLResponse<AccessToken>> httpResponse) {
        if (!httpResponse.isSuccess())
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
                                             server.getConfig().getAppId(),
                                             server.getConfig().getTokens()));
    }

    private void onRegister(HttpResponse<GraphQLResponse<User>> httpResponse) {
        if (!httpResponse.isSuccess())
            return;

        GraphQLResponse<User> graphQLResponse = httpResponse.body();
        if (!graphQLResponse.isSuccess())
            return;

        auth();
    }

}
