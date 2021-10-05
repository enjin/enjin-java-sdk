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

package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud player events.
 *
 * @see com.enjin.sdk.events.IEventService
 */
public class PlayerChannel implements IChannel {

    private final Platform platform;
    private final String project;
    private final String player;

    /**
     * Constructs a channel for the given network and player on a project.
     *
     * @param platform the platform
     * @param project the project's UUID
     * @param player the identity ID
     */
    public PlayerChannel(@NonNull Platform platform, String project, String player) {
        this.platform = platform;
        this.project = project;
        this.player = player;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.project.%s.player.%s",
                             platform.getNetwork().toLowerCase(),
                             project,
                             player);
    }

}
