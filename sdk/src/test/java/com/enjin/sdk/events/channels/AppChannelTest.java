package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppChannelTest {

    @Test
    void channel_Kovan_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.kovan.app.1234";
        final int APP = 1234;
        final Platform platform = PlatformUtils.KOVAN;
        final Channel channel = new AppChannel(platform, APP);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void channel_Mainnet_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.mainnet.app.1234";
        final int APP = 1234;
        final Platform platform = PlatformUtils.MAIN_NET;
        final Channel channel = new AppChannel(platform, APP);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}