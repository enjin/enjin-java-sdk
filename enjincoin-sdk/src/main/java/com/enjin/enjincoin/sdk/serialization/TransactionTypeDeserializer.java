package com.enjin.enjincoin.sdk.serialization;

import com.enjin.enjincoin.sdk.model.service.requests.TransactionType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class TransactionTypeDeserializer implements JsonDeserializer<TransactionType> {

    @Override
    public TransactionType deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
        TransactionType out = TransactionType.UNKNOWN;

        if (json.isJsonPrimitive()) {
            String value = json.getAsString();

            for (TransactionType type : TransactionType.values()) {
                if (type.name().equalsIgnoreCase(value)) {
                    out = type;
                    break;
                }
            }
        }

        return out;
    }

}
