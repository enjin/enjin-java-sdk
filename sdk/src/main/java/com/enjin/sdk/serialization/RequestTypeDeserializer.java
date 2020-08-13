package com.enjin.sdk.serialization;

import java.lang.reflect.Type;

import com.enjin.sdk.models.RequestType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

/**
 * A Gson serializer that can deserialize a {@link RequestType}.
 */
public class RequestTypeDeserializer implements JsonDeserializer<RequestType> {

    @Override
    public RequestType deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) {
        RequestType out = RequestType.UNKNOWN;

        if (json.isJsonPrimitive()) {
            String value = json.getAsString();

            for (RequestType type : RequestType.values()) {
                if (type.name().equalsIgnoreCase(value)) {
                    out = type;
                    break;
                }
            }
        }

        return out;
    }

}
