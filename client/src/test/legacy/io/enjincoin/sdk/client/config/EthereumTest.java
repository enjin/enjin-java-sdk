package io.enjincoin.sdk.client.config;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EthereumTest {

    private Ethereum ethereum;

    @Before
    public void setUp() {
        this.ethereum = ImmutableEthereum.builder().build();
    }

    @Test
    public void testGetMode() {
        assertThat(this.ethereum.getMode()).isEqualToIgnoringCase("geth_ipc");
    }

    @Test
    public void testGetPath() {
        assertThat(this.ethereum.getPath()).isEqualToIgnoringCase("\\\\.\\pipe\\geth.ipc");
    }

}
