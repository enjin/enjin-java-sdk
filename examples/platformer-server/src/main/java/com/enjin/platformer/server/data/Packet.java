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
