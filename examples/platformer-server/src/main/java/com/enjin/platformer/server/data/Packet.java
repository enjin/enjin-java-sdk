package com.enjin.platformer.server.data;

import com.enjin.platformer.server.serialization.PostProcessable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Packet implements PostProcessable {

    private static final Gson GSON = new GsonBuilder().create();

    @Getter
    private int id;

    @Getter
    private transient PacketType type;
    @Getter
    @Setter
    private transient JsonObject raw;

    protected Packet(PacketType type) {
        this.id = type.getId();
        this.type = type;
    }

    @Override
    public void process() {
        type = PacketType.of(id);
    }

    @Override
    public String toString() {
        if (raw == null)
            raw = (JsonObject) GSON.toJsonTree(this);
        return GSON.toJson(raw);
    }
}
