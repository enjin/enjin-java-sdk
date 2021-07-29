package com.enjin.platformer.server.data;

import com.enjin.platformer.server.game.Asset;
import com.enjin.sdk.models.AccessToken;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Map;

@Getter
public class PacketOutAuthenticated extends Packet {

    private AccessToken session;
    @SerializedName("app_uuid")
    private String appUuid;
    private Map<String, Asset> assets;

    public PacketOutAuthenticated(AccessToken session, String appUuid, Map<String, Asset> assets) {
        super(PacketType.AUTHENTICATED);
        this.session = session;
        this.appUuid = appUuid;
        this.assets = assets;
    }

}
