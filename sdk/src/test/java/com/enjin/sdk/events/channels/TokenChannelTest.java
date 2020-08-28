package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TokenChannelTest {

    @Test
    void channel_Kovan_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.kovan.token.0000000000000000";
        final String TOKEN = "0000000000000000";
        final Platform platform = PlatformUtils.KOVAN;
        final Channel channel = new TokenChannel(platform, TOKEN);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void channel_Mainnet_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.mainnet.token.0000000000000000";
        final String TOKEN = "0000000000000000";
        final Platform platform = PlatformUtils.MAIN_NET;
        final Channel channel = new TokenChannel(platform, TOKEN);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}