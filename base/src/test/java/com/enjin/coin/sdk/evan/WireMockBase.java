package com.enjin.coin.sdk.evan;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

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
