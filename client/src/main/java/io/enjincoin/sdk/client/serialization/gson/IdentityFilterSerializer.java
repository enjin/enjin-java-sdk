package io.enjincoin.sdk.client.serialization.gson;

import com.google.gson.*;
import io.enjincoin.sdk.client.service.identities.IdentityFilter;

import java.lang.reflect.Type;
import java.util.Map;

public class IdentityFilterSerializer implements JsonSerializer<IdentityFilter> {

    @Override
    public JsonElement serialize(IdentityFilter src, Type type, JsonSerializationContext context) {
        JsonArray root = new JsonArray();
        JsonObject obj = new JsonObject();
        JsonArray keys = new JsonArray();
        JsonArray values = new JsonArray();

        if (src.getMap() != null) {
            for (Map.Entry<String, Object> entry : src.getMap().entrySet()) {
                keys.add(entry.getKey());
                values.add(context.serialize(entry.getValue()));
            }
        }

        obj.add("key", keys);
        obj.add("field_value", values);

        root.add(obj);

        return root;
    }

}
