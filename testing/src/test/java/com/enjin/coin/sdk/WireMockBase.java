package com.enjin.coin.sdk;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class WireMockBase {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.wireMockConfig()
            .dynamicPort()
            .dynamicHttpsPort());

    @Before
    public void setup() {
        WireMock.configureFor("localhost", wireMockRule.port());
        wireMockRule.start();
    }

    @After
    public void tearDown() {
        wireMockRule.stop();
    }

}
