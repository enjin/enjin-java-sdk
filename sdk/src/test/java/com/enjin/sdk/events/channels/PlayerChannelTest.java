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
        final String expected = "enjincloud.test.project.1234.player.player1";
        final int project = 1234;
        final String player = "player1";
        final Platform platform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final Channel channel = new PlayerChannel(platform, project, player);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}