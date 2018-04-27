package client.service;

import org.junit.Before;

import io.enjincoin.sdk.client.ClientImpl;

public class BaseLiveServiceTest {

    //protected LegacyClientImpl client;
    protected ClientImpl client;

    @Before
    public void setUp() {
        String url = "https://enjin.v16studios.co.uk/";
        this.client = new ClientImpl(url, 2, false);
    }

}
