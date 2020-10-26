package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppChannelTest {

    private static final String PLATFORM_NAME = "test";

    @Test
    void channel_ReturnsExpectedString() {
        // Arrange
        final String expected = "enjincloud.test.app.1234";
        final int app = 1234;
        final Platform fakePlatform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final Channel channel = new AppChannel(fakePlatform, app);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}