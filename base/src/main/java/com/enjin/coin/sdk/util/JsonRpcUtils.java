package com.enjin.coin.sdk.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionOptions;

public class JsonRpcUtils {

	private static final Logger LOGGER = Logger.getLogger(JsonRpcUtils.class.getName());
	
	private boolean inTestMode = false;
	
	
	public boolean getInTestMode() {
		return inTestMode;
	}

	public void setInTestMode(boolean inTestMode) {
		this.inTestMode = inTestMode;
	}


	/**
	 * Method to send a json rpc request
	 * @param url
	 * @param responseClass 
	 * @param method 
	 * @return
	 */
	public Object sendJsonRpcRequest(String url, Class<?> responseClass, String method) {
		Object responseObject = sendJsonRpcRequest(url, responseClass, method, null);
		return responseObject;
	}
	
	
	/**
	 * Method to send a json rpc request
	 * @param url
	 * @param responseClass 
	 * @param method 
	 * @param params
	 * @return
	 */
	public Object sendJsonRpcRequest(String url, Class<?> responseClass, String method, Map<String, Object> params) {
		Object responseObject = null;
		
		if (ValidationUtils.isEmpty(url) || responseClass == null || ValidationUtils.isEmpty(method)) {
			LOGGER.warning("url or method passed in are null or empty or the responseClass is null");
			return responseObject;
		}		
		
		try {
			// Creating a new session to a JSON-RPC 2.0 web service at a specified URL
			// The JSON-RPC 2.0 server URL
			URL serverURL = new URL(url);
			
			// Create new JSON-RPC 2.0 client session
			JSONRPC2Session jsonRpcSession = new JSONRPC2Session(serverURL);
			JSONRPC2SessionOptions jsonRPC2SessionOptions = jsonRpcSession.getOptions();
			jsonRPC2SessionOptions.setRequestContentType(ContentType.TEXT_JSON);
			jsonRPC2SessionOptions.setAllowedResponseContentTypes(new String[]{ ContentType.TEXT_JSON, ContentType.APPLICATION_JSON, ContentType.APPLICATION_JSON_RPC });
			jsonRpcSession.setOptions(jsonRPC2SessionOptions);
			
			String requestId = Utils.generateRandomId(inTestMode);
			
			JSONRPC2Request jsonRpcRequest;
			if (ValidationUtils.isNotEmpty(params)) {
				jsonRpcRequest = new JSONRPC2Request(method, params, requestId);
			} else {
				jsonRpcRequest = new JSONRPC2Request(method, requestId);
			}

			LOGGER.info(String.format("jsonRpcRequest:%s", jsonRpcRequest.toJSONString()));
			
			// Send request - exception here
			JSONRPC2Response jsonRpcResponse = jsonRpcSession.send(jsonRpcRequest);
	
			// Print response result / error
			if (jsonRpcResponse != null && jsonRpcResponse.indicatesSuccess()) {
				String responseString = jsonRpcResponse.getResult().toString();
				LOGGER.info(String.format("responseString:%s", responseString));
				responseObject = JsonUtils.convertJsonToObject(responseString, responseClass);				
			} else if (jsonRpcResponse != null) {
				LOGGER.warning(String.format("Error Message:%s", jsonRpcResponse.getError().getMessage()));
			} else {
				LOGGER.warning("Error has occured - jsonRpcResponse is null");
			}
			
		} catch (MalformedURLException e) {
			LOGGER.warning(String.format("A MalformedURLException has occured. Exception: %s", StringUtils.exceptionToString(e)));
		} catch (JSONRPC2SessionException e) {
			LOGGER.warning(String.format("A JSONRPC2SessionException has occured. Exception: %s", StringUtils.exceptionToString(e)));
		}

		return responseObject;
	}

}
