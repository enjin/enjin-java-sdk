package com.enjin.sdk.events.channels;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.Platform;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WalletChannelTest {

    @Test
    void channel_Kovan_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.kovan.wallet.0x0";
        final String WALLET = "0x0";
        final Platform platform = PlatformUtils.KOVAN;
        final Channel channel = new WalletChannel(platform, WALLET);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void channel_Mainnet_ReturnCorrectString() {
        // Arrange
        final String expected = "enjincloud.mainnet.wallet.0x0";
        final String WALLET = "0x0";
        final Platform platform = PlatformUtils.MAIN_NET;
        final Channel channel = new WalletChannel(platform, WALLET);

        // Act
        String actual = channel.channel();

        // Assert
        assertEquals(expected, actual);
    }

}