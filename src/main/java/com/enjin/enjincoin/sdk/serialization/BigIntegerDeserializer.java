package com.enjin.enjincoin.sdk.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerDeserializer implements JsonDeserializer<BigInteger> {

    @Override
    public BigInteger deserialize(JsonElement json,
                                  Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException {
        BigInteger out = null;

        if (json.isJsonPrimitive()) {
            String s = json.getAsString().toLowerCase();

            try {
                if (s.contains(".") || s.contains("e") || s.contains("e+")) {
                    out = new BigDecimal(s).toBigInteger();
                } else {
                    out = new BigInteger(s);
                }
            } catch (Exception ex) {
                throw new JsonSyntaxException(String.format("Could not deserialize %s to BigInteger", s), ex);
            }
        }

        return out;
    }

}
