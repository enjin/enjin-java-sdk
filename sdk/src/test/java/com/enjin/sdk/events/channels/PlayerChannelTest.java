package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerChannelTest {

    @Test
    void channel_Kovan_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.kovan.app.1234.player.player1";
        final int APP = 1234;
        final String PLAYER = "player1";
        final Platform platform = PlatformUtils.KOVAN;
        final Channel channel = new PlayerChannel(platform, APP, PLAYER);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void channel_Mainnet_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.mainnet.app.1234.player.player1";
        final int APP = 1234;
        final String PLAYER = "player1";
        final Platform platform = PlatformUtils.MAIN_NET;
        final Channel channel = new PlayerChannel(platform, APP, PLAYER);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}