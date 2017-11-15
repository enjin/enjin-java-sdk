package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.http.ContentType;
import com.enjin.coin.sdk.util.FileUtils;
import com.enjin.coin.sdk.util.http.Header;
import com.enjin.coin.sdk.util.http.Protocol;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Ignore
public class BaseMockServer {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.wireMockConfig()
            .dynamicPort()
            .dynamicHttpsPort());

    /**
     * Constant for the json method label
     **/
    private static final String JSON_METHOD_LABEL = "$.method";

    /**
     * Constant for the hostname
     **/
    private static final String HOSTNAME = "localhost";

    /**
     * Base url for the identities
     **/
    private static final String IDENTITIES_URL = String.format("/%s", Constants.IDENTITIES_URL);
    /**
     * Base url for the tokens
     **/
    private static final String TOKENS_URL = String.format("/%s", Constants.TOKENS_URL);
    /**
     * Base url for the TransactionRequests
     **/
    private static final String TRANSACTION_REQUESTS_URL = String.format("/%s", Constants.TRANSACTION_REQUESTS_URL);
    /**
     * Base url for the events
     **/
    private static final String EVENTS_URL = String.format("/%s", Constants.EVENTS_URL);

    private static final String JSON_FILE_EXTENSION = ".response.json";
    private static final String JSON_FILE_BASE_FOLDER = "src/test/resources/examples/API/";

    @Before
    public void setUp() {
        startWiremockServer();
    }

    @After
    public void tearDown() {
        wireMockRule.stop();
    }

    /**
     * Method to start the wiremock server
     * Note: we dont actually stop the server as we want the server to be available to requests can be mocked
     */
    private void startWiremockServer() {
        WireMock.configureFor("localhost", wireMockRule.port());
        wireMockRule.start();

        //Formatted with https://www.freeformatter.com/json-formatter.html

        //Setup the identities stubs
        String identitiesGetMethod = "Identities.get";
        String identitiesListMethod = "Identities.list";
        String identitiesCreateMethod = "Identities.create";
        String identitiesUpdateMethod = "Identities.update";
        String identitiesDeleteMethod = "Identities.delete";

        setUpStub(IDENTITIES_URL, identitiesGetMethod);
        setUpStub(IDENTITIES_URL, identitiesListMethod);
        setUpStub(IDENTITIES_URL, identitiesCreateMethod);
        setUpStub(IDENTITIES_URL, identitiesUpdateMethod);
        setUpStub(IDENTITIES_URL, identitiesDeleteMethod);

        //Setup the tokens stubs
        String tokensGetMethod = "Tokens.get";
        String tokensListMethod = "Tokens.list";

        setUpStub(TOKENS_URL, tokensGetMethod);
        setUpStub(TOKENS_URL, tokensListMethod);

        //Setup the TransactionRequests stubs
        String transactionRequestsGetMethod = "TransactionRequests.get";
        String transactionRequestsListMethod = "TransactionRequests.list";
        String transactionRequestsCreateMethod = "TransactionRequests.create";
        String transactionRequestsCancelMethod = "TransactionRequests.cancel";

        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsGetMethod);
        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsListMethod);
        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsCreateMethod);
        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsCancelMethod);

        //Setup the events stubs
        String eventsGetMethod = "Events.get";
        String eventsListMethod = "Events.list";

        setUpStub(EVENTS_URL, eventsGetMethod);
        setUpStub(EVENTS_URL, eventsListMethod);

    }

    protected String getUrlFromPlatform(Platform platform) {
        return getURL(platform.getProtocol(), platform.getHost(), platform.getPort());
    }

    protected String getURL(String protocol, String hostname, int port) {
        return String.format("%s://%s:%d/", protocol, hostname, port);
    }

    protected Platform getPlatform() {
        return ImmutablePlatform.builder()
                .setHost(HOSTNAME)
                .setPort(wireMockRule.port())
                .setProtocol(Protocol.HTTP)
                .build();
    }

    /**
     * Method to set up the stub
     *
     * @param baseURL
     * @param methodToCall
     */
    private static void setUpStub(String baseURL, String methodToCall) {
        String fileToLoad = methodToCall + JSON_FILE_EXTENSION;

        setUpStub(baseURL, methodToCall, fileToLoad);
    }

    /**
     * Method to set up the stub
     *
     * @param baseURL
     * @param methodToCall
     * @param fileToLoad
     */
    private static void setUpStub(String baseURL, String methodToCall, String fileToLoad) {
        String filePath = JSON_FILE_BASE_FOLDER + fileToLoad;
        String fileContents = FileUtils.getFileContents(filePath);

        // See http://wiremock.org/docs/request-matching/ for request matching
        stubFor(post(urlEqualTo(baseURL))
                .withHeader(Header.ACCEPT, equalTo(ContentType.ANY))
                .withRequestBody(matchingJsonPath(JSON_METHOD_LABEL, equalTo(methodToCall)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader(Header.CONTENT_TYPE, ContentType.TEXT_JSON)
                        .withBody(fileContents)));
    }
}
