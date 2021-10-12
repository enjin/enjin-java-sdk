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

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerChannelTest {

    private static final String PLATFORM_NAME = "test";

    @Test
    void channel_ReturnsExpectedString() {
        // Arrange
        final String expected = "enjincloud.test.project.xyz.player.player1";
        final String project = "xyz";
        final String player = "player1";
        final Platform platform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final IChannel channel = new PlayerChannel(platform, project, player);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}