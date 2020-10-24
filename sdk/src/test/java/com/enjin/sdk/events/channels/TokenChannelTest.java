package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TokenChannelTest {

    private static final String PLATFORM_NAME = "test";

    @Test
    void channel_ReturnsExpectedString() {
        // Arrange
        final String expected = "enjincloud.test.token.0";
        final String token = "0";
        final Platform platform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final Channel channel = new TokenChannel(platform, token);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}