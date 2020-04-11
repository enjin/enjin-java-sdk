package com.enjin.platformer.server.serialization;

import com.enjin.platformer.server.data.Packet;
import com.enjin.platformer.server.data.PacketType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.lang.reflect.Type;

public class PacketFactory implements TypeAdapterFactory {

    private static final Gson GSON = new GsonBuilder().create();
    private static final String KEY_ID = "id";

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!Packet.class.isAssignableFrom(type.getRawType()))
            return null;
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        return new PacketAdapter<>(delegate);
    }

    @RequiredArgsConstructor
    public class PacketAdapter<T> extends TypeAdapter<T> {

        private final TypeAdapter<T> delegate;

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            delegate.write(out, value);
        }

        @Override
        public T read(JsonReader in) {
            JsonElement elem = GSON.fromJson(in, JsonElement.class);
            if (!elem.isJsonObject())
                return null;

            JsonObject obj = elem.getAsJsonObject();
            if (!obj.has(KEY_ID) || !obj.get(KEY_ID).isJsonPrimitive())
                return null;

            JsonPrimitive prim = obj.getAsJsonPrimitive(KEY_ID);
            if (!prim.isNumber())
                return null;

            int id = prim.getAsInt();
            PacketType type = PacketType.of(id);
            return GSON.fromJson(elem, (Type) type.getClazz());
        }

    }

}
