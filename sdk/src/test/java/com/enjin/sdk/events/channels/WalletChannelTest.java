package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WalletChannelTest {

    private static final String PLATFORM_NAME = "test";

    @Test
    void channel_Kovan_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.test.wallet.0";
        final String wallet = "0";
        final Platform platform = PlatformUtils.createFakePlatform(PLATFORM_NAME);
        final Channel channel = new WalletChannel(platform, wallet);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}