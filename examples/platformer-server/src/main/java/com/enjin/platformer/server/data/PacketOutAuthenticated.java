package com.enjin.platformer.server.data;

import com.enjin.platformer.server.game.Token;
import com.enjin.sdk.models.AccessToken;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Map;

@Getter
public class PacketOutAuthenticated extends Packet {

    private AccessToken session;
    @SerializedName("app_id")
    private int appId;
    private Map<String, Token> tokens;

    public PacketOutAuthenticated(AccessToken session, int appId, Map<String, Token> tokens) {
        super(PacketType.AUTHENTICATED);
        this.session = session;
        this.appId = appId;
        this.tokens = tokens;
    }

}
