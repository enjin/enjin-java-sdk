package client.service;

import org.junit.Before;

import io.enjincoin.sdk.client.ClientImpl;
import io.enjincoin.sdk.client.config.Config;

public class BaseLiveServiceTest {

    //protected LegacyClientImpl client;
    protected ClientImpl client;
    protected Config config;

    @Before
    public void setUp() {
        String url = "https://enjin.v16studios.co.uk/";
        this.client = new ClientImpl(url);
    }

}
