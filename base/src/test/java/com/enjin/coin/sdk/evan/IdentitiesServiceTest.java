package com.enjin.coin.sdk.evan;

import com.enjin.coin.sdk.util.http.ContentType;
import com.enjin.coin.sdk.util.http.Header;
import com.github.tomakehurst.wiremock.common.Json;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;
import org.junit.Assert;
import org.junit.Test;
import wiremock.com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class IdentitiesServiceTest extends JsonRpcBase {

    private static final String API_URL = "/api.php";
    private static final String RESOLVED_API_URL = "%s://localhost:%d/api.php";

    private static final String IDENTITIES_CREATE_METHOD = "Identities.create";
    @SuppressWarnings("serial")
    private static final HashMap<String, Object> IDENTITIES_CREATE_REQUETS_PARAMS = new HashMap<String, Object>() {
        {
            put("auth", "xxxxxxxx");
            put("identity", new HashMap<String, Object>() {{
                put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                put("player_name", "notch");
            }});
        }
    };
    private static final String IDENTITIES_CREATE_RESPONSE = "{ \"jsonrpc\": \"2.0\", \"result\": { \"identity_id\": \"123456\", \"identity_code\": \"XUAIG\" }, \"id\": \"1\" }";

    @Test
    public void create() {
        wireMockRule.stubFor(post(urlEqualTo(API_URL))
                .withHeader(Header.ACCEPT, equalTo(ContentType.ANY))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader(Header.CONTENT_TYPE, ContentType.TEXT_JSON)
                        .withBody(IDENTITIES_CREATE_RESPONSE)));

        JSONRPC2Session session = createSession(String.format(RESOLVED_API_URL, "http", wireMockRule.port()));
        JSONRPC2Request request = createRequest(IDENTITIES_CREATE_METHOD, IDENTITIES_CREATE_REQUETS_PARAMS, 1);

        Assert.assertNotNull(session);
        Assert.assertNotNull(request);

        JSONRPC2Response response = null;
        try {
            response = session.send(request);
        } catch (JSONRPC2SessionException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(response);

        JsonNode expected = Json.node(IDENTITIES_CREATE_RESPONSE);
        JsonNode actual = Json.node(response.toJSONString());
        Assert.assertEquals(expected, actual);
    }

}
