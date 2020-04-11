package com.enjin.platformer.server.data;

import com.enjin.platformer.server.serialization.PostProcessable;
import lombok.Getter;

public class Packet implements PostProcessable {

    @Getter
    private int id;

    @Getter
    private transient PacketType type;

    @Override
    public void process() {
        type = PacketType.of(id);
    }

}
