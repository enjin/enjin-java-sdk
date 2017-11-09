package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.vo.event.GetEventDataVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionOptions;
@RunWith(PowerMockRunner.class)
@PrepareForTest(JsonRpcUtils.class)
public class JsonRpcUtilsTest {

	private JsonRpcUtils jsonRpcUtils;
	
	@Before
	public void setUp() {
		jsonRpcUtils = new JsonRpcUtils();
	}
	@Test
	public void testConstructor() {
		JsonUtils jsonUtils = new JsonUtils();
		assertNotNull(jsonUtils);
	}
	
	
	@Test
	public void testSendJsonRpcRequestNoParamsPassed_SuccessResponse() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		String responseJson = JsonUtils.convertObjectToJson(createIdentityRequestVO);
		
		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);
		JSONRPC2Response mockJSONRPC2Response = Mockito.mock(JSONRPC2Response.class);
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Object.class).withArguments(Mockito.anyString(), Mockito.anyString()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenReturn(mockJSONRPC2Response);
		Mockito.when(mockJSONRPC2Response.indicatesSuccess()).thenReturn(true);
		Mockito.when(mockJSONRPC2Response.getResult()).thenReturn(responseJson);
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method);
		assertNotNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).indicatesSuccess();
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).getResult();
	}
	
	@Test
	public void testSendJsonRpcRequest_UrlIsEmpty() {
		String url = "";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method";
		Map<String, Object> params = new HashMap<>();
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
	}
	@Test
	public void testSendJsonRpcRequest_UrlIsNull() {
		String url = null;
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method";
		Map<String, Object> params = new HashMap<>();
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
	}
	
	@Test
	public void testSendJsonRpcRequest_ResponseClassIsNull() {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = null;
		String method = "method";
		Map<String, Object> params = new HashMap<>();
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
	}
	@Test
	public void testSendJsonRpcRequest_MethodIsEmpty() {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;		
		String method = "";
		Map<String, Object> params = new HashMap<>();
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
	}
	@Test
	public void testSendJsonRpcRequest_MethodIsNull() {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;		
		String method = null;
		Map<String, Object> params = new HashMap<>();
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
	}
	
	@Test
	public void testSendJsonRpcRequest_MalformedUrlExceptionCreatingURL() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;		
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenThrow(new MalformedURLException());

		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
	}
	
	@Test
	public void testSendJsonRpcRequest_JSONRPC2SessionExceptionSendingRequest() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;		
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");
		
		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Map.class, Object.class).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenThrow(new JSONRPC2SessionException("exception"));
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
	}
	
	@Test
	public void testSendJsonRpcRequest_SuccessResponse() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		String responseJson = JsonUtils.convertObjectToJson(createIdentityRequestVO);
		
		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);
		JSONRPC2Response mockJSONRPC2Response = Mockito.mock(JSONRPC2Response.class);
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Map.class, Object.class).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenReturn(mockJSONRPC2Response);
		Mockito.when(mockJSONRPC2Response.indicatesSuccess()).thenReturn(true);
		Mockito.when(mockJSONRPC2Response.getResult()).thenReturn(responseJson);
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNotNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).indicatesSuccess();
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).getResult();
	}
	@Test
	public void testSendJsonRpcRequest_SuccessResponseNullParamsPassed() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method1";
		Map<String, Object> params = null;
		CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO();
		createIdentityRequestVO.setAuth("auth");
		String responseJson = JsonUtils.convertObjectToJson(createIdentityRequestVO);
		
		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);
		JSONRPC2Response mockJSONRPC2Response = Mockito.mock(JSONRPC2Response.class);
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Object.class).withArguments(Mockito.anyString(), Mockito.anyString()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenReturn(mockJSONRPC2Response);
		Mockito.when(mockJSONRPC2Response.indicatesSuccess()).thenReturn(true);
		Mockito.when(mockJSONRPC2Response.getResult()).thenReturn(responseJson);
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNotNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).indicatesSuccess();
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).getResult();
	}
	@Test
	public void testSendJsonRpcRequest_ResponseIsNull() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");

		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);

		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Map.class, Object.class).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenReturn(null);
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
	}
	
	@Test
	public void testSendJsonRpcRequest_ResponseIsNotSuccessful() throws Exception {
		String url = "http://localhost:8080/Identities.php";
		Class<?> responseClass = GetEventDataVO.class;
		String method = "method1";
		Map<String, Object> params = new HashMap<>();
		params.put("param1", "value1");

		URL mockUrl = PowerMockito.mock(URL.class);
		JSONRPC2Session mockJSONRPC2Session = PowerMockito.mock(JSONRPC2Session.class);
		JSONRPC2SessionOptions mockOptions = Mockito.mock(JSONRPC2SessionOptions.class);
		JSONRPC2Request mockJSONRPC2Request = Mockito.mock(JSONRPC2Request.class);
		JSONRPC2Response mockJSONRPC2Response = Mockito.mock(JSONRPC2Response.class);
		JSONRPC2Error mockJSONRPC2Error = Mockito.mock(JSONRPC2Error.class);
		
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(mockUrl);
		PowerMockito.whenNew(JSONRPC2Session.class).withArguments(Mockito.isA(URL.class)).thenReturn(mockJSONRPC2Session);
		Mockito.when(mockJSONRPC2Session.getOptions()).thenReturn(mockOptions);
		PowerMockito.whenNew(JSONRPC2Request.class).withParameterTypes(String.class, Map.class, Object.class).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any()).thenReturn(mockJSONRPC2Request);
		Mockito.when(mockJSONRPC2Session.send(Mockito.isA(JSONRPC2Request.class))).thenReturn(mockJSONRPC2Response);
		Mockito.when(mockJSONRPC2Response.indicatesSuccess()).thenReturn(false);
		Mockito.when(mockJSONRPC2Response.getError()).thenReturn(mockJSONRPC2Error);
		Mockito.when(mockJSONRPC2Error.getMessage()).thenReturn("Error Message");
		
		Object responseObject = jsonRpcUtils.sendJsonRpcRequest(url, responseClass, method, params );
		assertNull(responseObject);
		
		PowerMockito.verifyNew(URL.class, Mockito.times(1)).withArguments(Mockito.anyString());
		PowerMockito.verifyNew(JSONRPC2Session.class, Mockito.times(1)).withArguments(Mockito.isA(URL.class));
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).getOptions();
		PowerMockito.verifyNew(JSONRPC2Request.class, Mockito.times(1)).withArguments(Mockito.anyString(), Mockito.isA(Map.class), Mockito.any());
		Mockito.verify(mockJSONRPC2Session, Mockito.times(1)).send(Mockito.isA(JSONRPC2Request.class));
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).indicatesSuccess();
		Mockito.verify(mockJSONRPC2Response, Mockito.times(1)).getError();
		Mockito.verify(mockJSONRPC2Error, Mockito.times(1)).getMessage();
	}
}
