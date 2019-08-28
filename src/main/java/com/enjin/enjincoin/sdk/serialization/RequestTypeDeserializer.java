package com.enjin.enjincoin.sdk.serialization;

import com.enjin.enjincoin.sdk.model.service.notifications.RequestType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class RequestTypeDeserializer implements JsonDeserializer<RequestType> {

    @Override
    public RequestType deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
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
