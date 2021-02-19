package com.enjin.platformer.server.data;

import com.enjin.platformer.server.game.Asset;
import com.enjin.sdk.models.AccessToken;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Map;

@Getter
public class PacketOutAuthenticated extends Packet {

    private AccessToken session;
    @SerializedName("app_id")
    private int appId;
    private Map<String, Asset> assets;

    public PacketOutAuthenticated(AccessToken session, int appId, Map<String, Asset> assets) {
        super(PacketType.AUTHENTICATED);
        this.session = session;
        this.appId = appId;
        this.assets = assets;
    }

}
