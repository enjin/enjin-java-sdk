package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AssetChannelTest {

    private static final String PLATFORM_NAME = "test";

    @Test
    void channel_ReturnsExpectedString() {
        // Arrange
        final String expected = "enjincloud.test.asset.0";
        final String asset = "0";
        final Platform platform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final Channel channel = new AssetChannel(platform, asset);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}