package com.enjin.coin.sdk.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

public class JsonRpcUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonRpcUtils.class);	
	
	/**
	 * Method to send a json rpc request
	 * @param url
	 * @param responseClass 
	 * @param method 
	 * @param params
	 * @return
	 */
	public static Object sendJsonRpcRequest(String url, Class<?> responseClass, String method, Map<String, Object> params) {
		Object responseObject = null;
		
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(method)) {
			LOGGER.error("url or method passed in are null or empty");
			return responseObject;
		}		
		
		try {
			// Creating a new session to a JSON-RPC 2.0 web service at a specified URL
			// The JSON-RPC 2.0 server URL
			URL serverURL = new URL(url);
			
			// Create new JSON-RPC 2.0 client session
			JSONRPC2Session mySession = new JSONRPC2Session(serverURL);
			mySession.getOptions().setRequestContentType(Constants.TYPE_JSON_RPC);
			
			String requestId = Utils.generateRandomId();
			
			JSONRPC2Request jsonRpcRequest = new JSONRPC2Request(method, params, requestId);
			LOGGER.info("jsonRpcRequest:{}", jsonRpcRequest);
			// Send request
			JSONRPC2Response jsonRpcResponse = mySession.send(jsonRpcRequest);
	
			// Print response result / error
			if (jsonRpcResponse != null && jsonRpcResponse.indicatesSuccess()) {
				String responseString = jsonRpcResponse.getResult().toString();
				
				responseObject = JsonUtils.convertJsonToObject(responseString, responseClass);
				
			} else if (jsonRpcResponse != null) {
				LOGGER.error("Message:{}", jsonRpcResponse.getError().getMessage());
			} else {
				LOGGER.error("Error has occured");
			}
			
		} catch (MalformedURLException e) {
			LOGGER.error("A MalformedURLException has occured. Exception: {}", e);
		} catch (JSONRPC2SessionException e) {
			LOGGER.error("A JSONRPC2SessionException has occured. Exception: {}", e);
		}

		return responseObject;
	}

}
