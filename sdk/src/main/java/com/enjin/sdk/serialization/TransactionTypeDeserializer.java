package com.enjin.sdk.serialization;

import java.lang.reflect.Type;

import com.enjin.sdk.models.request.TransactionType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

/**
 * A Gson serializer that can deserialize a {@link TransactionType}.
 */
public class TransactionTypeDeserializer implements JsonDeserializer<TransactionType> {

    @Override
    public TransactionType deserialize(JsonElement json,
                                       Type typeOfT,
                                       JsonDeserializationContext context) {
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
