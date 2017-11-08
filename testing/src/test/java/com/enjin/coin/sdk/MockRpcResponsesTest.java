package com.enjin.coin.sdk;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.WireMockServer;

public class MockRpcResponsesTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MockRpcResponsesTest.class);	
	
	
	/** Port wiremock will run in **/
	private static final int WIREMOCK_PORT = 8080;
	
	/** Constant for the json method label **/
	private static final String JSON_METHOD_LABEL = "$.method";
	
	/** Base url for the identities **/
	private static final String IDENTITIES_URL = "/Identities.php";
	/** Base url for the tokens **/
	private static final String TOKENS_URL = "/Tokens.php";
	/** Base url for the TransactionRequests **/
	private static final String TRANSACTION_REQUESTS_URL = "/TransactionRequests.php";
	/** Base url for the events **/
	private static final String EVENTS_URL = "/Events.php";
	
	/** Constant for the accept header **/
	//private static final String ACCEPT_HEADER = "Accept";	
	/** Constant for the content type header **/
	private static final String CONTENT_TYPE_HEADER = "Content-Type";	
	/** Constant for the json rpc type **/
	private static final String TYPE_JSON_RPC = "application/json-rpc";
	
	/**
	 * Main method to run the class
	 * @param args
	 */
	public static void main(String args[]) {
		MockRpcResponsesTest identitiesResponseTest = new MockRpcResponsesTest();
		identitiesResponseTest.startWiremockServer();
	}

	/**
	 * Method to start the wiremock server
	 * Note: we dont actually stop the server as we want the server to be available to requests can be mocked
	 */
	private void startWiremockServer() {
		WireMockServer wireMockServer = new WireMockServer(WIREMOCK_PORT);
		
		wireMockServer.start();
		
		//Formatted with https://www.freeformatter.com/json-formatter.html
		
		//Setup the identities stubs
		String identitiesGetMethod      = "Identities.get";
		String identitiesGetResponse    = "{\"jsonrpc\":\"2.0\",\"result\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\", \"unknown_1\":\"unknown_1_value\", \"unknown_2\":\"unknown_2_value\"},\"id\":\"1\"}";
		//String identitiesGetResponse    = "{\"jsonrpc\":\"2.0\",\"result\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\"},\"id\":\"1\"}";
		String identitiesListMethod     = "Identities.list";
		String identitiesListResponse   = "{\"jsonrpc\":\"2.0\",\"result\":[{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"player_name\":\"john\"},{\"identity_id\":\"234567\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"player_name\":\"george\"}],\"id\":\"1\"}";
		String identitiesCreateMethod   = "Identities.create";
		String identitiesCreateResponse = "{\"jsonrpc\":\"2.0\",\"result\":{\"identity_id\":\"123456\",\"identity_code\":\"XUAIG\"},\"id\":\"1\"}";
		String identitiesUpdateMethod   = "Identities.update";
		String identitiesUpdateResponse = "{\"jsonrpc\":\"2.0\",\"result\":{\"identity\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x1111111111111111111111111111111111111111\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\"}},\"id\":\"1\"}";
		String identitiesDeleteMethod   = "Identities.delete";
		String identitiesDeleteResponse = "{\"jsonrpc\":\"2.0\",\"result\":true,\"id\":\"1\"}";
		
		setUpStub(IDENTITIES_URL, identitiesGetMethod, identitiesGetResponse);
		setUpStub(IDENTITIES_URL, identitiesListMethod, identitiesListResponse);
		setUpStub(IDENTITIES_URL, identitiesCreateMethod, identitiesCreateResponse);
		setUpStub(IDENTITIES_URL, identitiesUpdateMethod, identitiesUpdateResponse);
		setUpStub(IDENTITIES_URL, identitiesDeleteMethod, identitiesDeleteResponse);		
		
		//Setup the tokens stubs
		String tokensGetMethod   = "Tokens.get";
		String tokensGetResponse = "{\"jsonrpc\":\"2.0\",\"result\":{\"token_id\":\"123456\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Sword of Glory\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"100000\",\"exchangeRate\":\"1000000000000000000\",\"decimals\":\"0\",\"maxMeltFee\":\"0\",\"transferable\":\"0\"},\"id\":\"1\"}";
		String tokensListMethod   = "Tokens.list";
		String tokensListResponse = "{\"jsonrpc\":\"2.0\",\"result\":[{\"token_id\":\"234567\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Sword of Glory\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"100000\",\"exchangeRate\":\"1000000000000000000\",\"decimals\":\"0\",\"maxMeltFee\":\"0\",\"meltFee\":\"0\",\"transferable\":\"0\"},{\"token_id\":\"234568\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Axe of Doom\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"2000\",\"exchangeRate\":\"150000000000000000\",\"decimals\":\"0\",\"maxMeltFee\":\"25\",\"meltFee\":\"20\",\"transferable\":\"1\"},{\"token_id\":\"234569\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Shillings\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"1000000000000\",\"exchangeRate\":\"1000000000000\",\"decimals\":\"2\",\"maxMeltFee\":\"5\",\"meltFee\":\"5\",\"transferable\":\"2\"}],\"id\":\"1\"}";
		
		setUpStub(TOKENS_URL, tokensGetMethod, tokensGetResponse);		
		setUpStub(TOKENS_URL, tokensListMethod, tokensListResponse);		
		
		//Setup the TransactionRequests stubs
		String transactionRequestsGetMethod    = "TransactionRequests.get";
		String transactionRequestsGetResponse  = "{\"jsonrpc\":\"2.0\",\"result\":{\"txr_id\":12345,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"12345\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"send\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"title\":\"Mineplex: /transfer alice 3 ENJ\",\"value\":{\"ENJ\":\"3000000000000000000\"}},\"id\":\"1\"}";
		String transactionRequestsListMethod   = "TransactionRequests.list";
		String transactionRequestsListResponse = "{\"jsonrpc\":\"2.0\",\"result\":[{\"txr_id\":123,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"54321\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"send\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"title\":\"Mineplex: /transfer alice 3 ENJ\",\"value\":{\"ENJ\":\"3000000000000000000\"},\"state\":\"confirmed\"},{\"txr_id\":234,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"54321\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"buy\",\"icon\":\"https://enjincoin.io/images/loading.png\",\"title\":\"Buy Golden Sword with Mineplex Coins\",\"value\":{\"45678\":\"100\"},\"state\":\"pending\"},{\"txr_id\":345,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"54321\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"sell\",\"icon\":\"https://enjincoin.io/images/loading.png\",\"title\":\"Sell Bronze Axe for Mineplex Coins\",\"value\":{\"67890\":\"1\"},\"state\":\"accepted\"}],\"id\":\"1\"}";
		String transactionRequestsCreateMethod   = "TransactionRequests.create";
		String transactionRequestsCreateResponse = "{\"jsonrpc\":\"2.0\",\"result\":{\"txr_id\":12345,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"12345\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"send\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"title\":\"Mineplex: /transfer alice 3 ENJ\",\"value\":{\"ENJ\":\"3000000000000000000\"}},\"id\":\"1\"}";
		String transactionRequestsCancelMethod   = "TransactionRequests.cancel";
		String transactionRequestsCancelResponse = "{\"jsonrpc\":\"2.0\",\"result\":true,\"id\":\"1\"}";
		
		setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsGetMethod, transactionRequestsGetResponse);
		setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsListMethod, transactionRequestsListResponse);
		setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsCreateMethod, transactionRequestsCreateResponse);
		setUpStub(TRANSACTION_REQUESTS_URL, transactionRequestsCancelMethod, transactionRequestsCancelResponse);
					
		
		//Setup the events stubs
		String eventsGetMethod   = "Events.get";
		String eventsGetResponse = "{\"jsonrpc\":\"2.0\",\"result\":{\"event_id\":\"123456789\",\"event_type\":\"identity_linked\",\"timestamp\":\"1510000000\",\"app_id\":\"1234\",\"data\":{\"identity\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\"}}},\"id\":\"1\"}";
		String eventsListMethod   = "Events.list";
		String eventsListResponse = "{\"jsonrpc\":\"2.0\",\"result\":[{\"event_id\":\"123456789\",\"event_type\":\"identity_created\",\"timestamp\":\"1510000000\",\"app_id\":\"1234\",\"data\":{\"identity\":{\"identity_id\":\"123456\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\"}}},{\"event_id\":\"123456790\",\"event_type\":\"identity_linked\",\"timestamp\":\"1510000001\",\"app_id\":\"1234\",\"data\":{\"identity\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\"}}},{\"event_id\":\"123456791\",\"event_type\":\"identity_updated\",\"timestamp\":\"1510000002\",\"app_id\":\"1234\",\"data\":{\"identity\":{\"identity_id\":\"123456\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\",\"uuid\":\"069a79f4-44e9-4726-a5be-fca90e38aaf5\",\"player_name\":\"notch\"}}},{\"event_id\":\"123456792\",\"event_type\":\"transaction_request\",\"timestamp\":\"1510000003\",\"app_id\":\"1234\",\"data\":{\"txr_id\":123,\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"recipient\":{\"identity_id\":\"54321\",\"player_name\":\"alice\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"type\":\"send\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"title\":\"Mineplex: /transfer alice 3 ENJ\",\"value\":{\"ENJ\":\"3000000000000000000\"},\"state\":\"confirmed\"}},{\"event_id\":\"123456793\",\"event_type\":\"balance_updated\",\"timestamp\":\"1510000004\",\"app_id\":\"1234\",\"data\":{\"balances\":[{\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"from\":{\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"balance_pending\":{\"ENJ\":\"100\",\"123456\":\"53\"},\"balance_confirmed\":{\"234567\":\"10\",\"345678\":\"20\"}}]}},{\"event_id\":\"123456793\",\"event_type\":\"balance_melted\",\"timestamp\":\"1510000004\",\"app_id\":\"1234\",\"data\":{\"identity\":{\"identity_id\":\"12345\",\"player_name\":\"joe\",\"ethereum_address\":\"0x0000000000000000000000000000000000000000\"},\"balance_pending\":{\"123456\":\"53\"},\"balance_confirmed\":{\"345678\":\"20\"}}},{\"event_id\":\"123456794\",\"event_type\":\"token_updated\",\"timestamp\":\"1510000005\",\"app_id\":\"1234\",\"data\":{\"token_id\":\"234567\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Sword of Glory\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"100000\",\"exchangeRate\":\"1000000000000000000\",\"decimals\":\"0\",\"maxMeltFee\":\"0\",\"meltFee\":\"0\",\"transferable\":\"0\"}},{\"event_id\":\"123456795\",\"event_type\":\"token_created\",\"timestamp\":\"1510000006\",\"app_id\":\"1234\",\"data\":{\"token_id\":\"234567\",\"creator\":\"0x0000000000000000000000000000000000000000\",\"adapter\":\"0x0000000000000000000000000000000000000000\",\"name\":\"Sword of Glory\",\"icon\":\"https://enjincoin.io/images/bubble.png\",\"totalSupply\":\"100000\",\"exchangeRate\":\"1000000000000000000\",\"decimals\":\"0\",\"maxMeltFee\":\"0\",\"meltFee\":\"0\",\"transferable\":\"0\"}}],\"id\":\"1\"}";
		
		setUpStub(EVENTS_URL, eventsGetMethod, eventsGetResponse);		
		setUpStub(EVENTS_URL, eventsListMethod, eventsListResponse);	
		
		//wireMockServer.stop();		
	}

	/**
	 * Method to set up the stub
	 * 
	 * @param url
	 * @param method
	 * @param response
	 */
	private void setUpStub(String url, String method, String response) {
		// See http://wiremock.org/docs/request-matching/ for request matching
		stubFor(post(urlEqualTo(url))
				//.withHeader(ACCEPT_HEADER, equalTo(TYPE_JSON_RPC))
				.withRequestBody(matchingJsonPath(JSON_METHOD_LABEL, equalTo(method)))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader(CONTENT_TYPE_HEADER, TYPE_JSON_RPC)
						.withBody(response)));
	}
}
