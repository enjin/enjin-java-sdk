/* Copyright 2021 Enjin Pte. Ltd.
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
