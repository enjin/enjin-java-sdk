package com.enjin.coin.sdk;


import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

public class IdentitiesTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void create() {
        stubFor(post(urlEqualTo("/Identities.php"))
                .withHeader("Accept", equalTo("application/json-rpc"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json-rpc")
                        .withBody("{ \"jsonrpc\": \"2.0\", \"result\": { \"identity_id\": \"123456\", \"identity_code\": \"XUAIG\" }, \"id\": \"1\" }")));
    }

}
