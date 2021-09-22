/* Copyright 2021 Enjin Pte Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.serialization;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

/**
 * A Gson serializer that can deserialize an integer from scientific notation.
 */
public class BigIntegerDeserializer implements JsonDeserializer<BigInteger> {

    @Override
    public BigInteger deserialize(JsonElement json,
                                  Type typeOfT,
                                  JsonDeserializationContext context) {
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
