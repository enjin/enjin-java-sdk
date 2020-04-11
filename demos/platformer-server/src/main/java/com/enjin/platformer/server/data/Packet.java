package com.enjin.platformer.server.data;

import com.enjin.platformer.server.serialization.PostProcessable;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

public class Packet implements PostProcessable {

    @Getter
    private int id;

    @Getter
    private transient PacketType type;
    @Getter
    @Setter
    private transient JsonObject raw;

    @Override
    public void process() {
        type = PacketType.of(id);
    }

}
