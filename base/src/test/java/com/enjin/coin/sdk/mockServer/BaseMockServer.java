package com.enjin.coin.sdk.mockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;

import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.FileUtils;
import com.enjin.coin.sdk.util.http.ContentType;
import com.enjin.coin.sdk.util.http.Header;
import com.enjin.coin.sdk.util.http.Protocol;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

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

    private static final String JSON_FILE_EXTENSION = "response.json";
    private static final String JSON_FILE_BASE_FOLDER = "src/test/resources/examples/API";

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
        String identitiesFolder       = "Identities";
        String identitiesGetMethod    = "get";
        String identitiesCreateMethod = "create";
        String identitiesUpdateMethod = "update";
        String identitiesDeleteMethod = "delete";

        setUpStub(IDENTITIES_URL, identitiesFolder, identitiesGetMethod);
        setUpStub(IDENTITIES_URL, identitiesFolder, identitiesCreateMethod);
        setUpStub(IDENTITIES_URL, identitiesFolder, identitiesUpdateMethod);
        setUpStub(IDENTITIES_URL, identitiesFolder, identitiesDeleteMethod);

        //Setup the tokens stubs
        String tokensFolder    = "Tokens";
        String tokensGetMethod = "get";

        setUpStub(TOKENS_URL, tokensFolder, tokensGetMethod);

        //Setup the TransactionRequests stubs
        String transactionRequestsFolder       = "TransactionRequests";
        String transactionRequestsGetMethod    = "get";
        String transactionRequestsCreateMethod = "create";
        String transactionRequestsCancelMethod = "cancel";

        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsFolder, transactionRequestsGetMethod);
        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsFolder, transactionRequestsCreateMethod);
        setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsFolder, transactionRequestsCancelMethod);

        //Setup the events stubs
        String eventsFolder     = "Events";
        String eventsGetMethod = "get";

        setUpStub(EVENTS_URL, eventsFolder, eventsGetMethod);
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
    protected Notification getNotification() {
        return ImmutableNotification.builder()
                .setActivityTimeout(4000l)
                .setAppChannel("channel")
                .setAppId("appId")
                .setAppKey("appKey")
                .setAppSecret("appSecret")
                .setCluster("eu")
                .build();
    }
    /**
     * Method to set up the stub
     *
     * @param baseURL
     * @param folder
     * @param methodToCall
     */
    private static void setUpStub(String baseURL, String folder, String methodToCall) {
        String fileToLoad = String.format("%s/%s/%s.%s", JSON_FILE_BASE_FOLDER, folder, methodToCall, JSON_FILE_EXTENSION);
        String fileContents = FileUtils.getFileContents(fileToLoad);

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
