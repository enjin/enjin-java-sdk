package com.enjin.coin.sdk.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

public class JsonRpcUtils {

	/**
	 * Method to send a json rpc request
	 * @param url
	 * @param responseClass 
	 * @param method 
	 * @param params
	 * @param requestId
	 * @return
	 */
	public static Object sendJsonRpcRequest(String url, Class<?> responseClass, String method, Map<String, Object> params, Integer requestId) {
		Object responseObject = null;
		
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(method) || requestId == null) {
			//TODO: replace System.out with logging framework
			System.out.println("url or method or requestId passed in are null or empty or the requestId is null");
			return responseObject;
		}		
		
		// Creating a new session to a JSON-RPC 2.0 web service at a specified URL
		// The JSON-RPC 2.0 server URL
		URL serverURL = null;

		try {
			serverURL = new URL(url);

		} catch (MalformedURLException e) {
			System.out.println("A MalformedURLException has occured. Exception: " + e);
			return responseObject;
		}

		// Create new JSON-RPC 2.0 client session
		JSONRPC2Session mySession = new JSONRPC2Session(serverURL);
		mySession.getOptions().setRequestContentType(Constants.TYPE_JSON_RPC);
		
		
		JSONRPC2Request jsonRpcRequest = new JSONRPC2Request(method, params, requestId);
		System.out.println("jsonRpcRequest:"+jsonRpcRequest);
		// Send request
		JSONRPC2Response jsonRpcResponse = null;

		try {
			jsonRpcResponse = mySession.send(jsonRpcRequest);

		} catch (JSONRPC2SessionException e) {
			System.out.println("A JSONRPC2SessionException has occured. Exception: " + e);
			return responseObject;
		}

		// Print response result / error
		if (jsonRpcResponse != null && jsonRpcResponse.indicatesSuccess()) {
			String responseString = jsonRpcResponse.getResult().toString();
			
			responseObject = JsonUtils.convertJsonToObject(responseString, responseClass);
			
		} else if (jsonRpcResponse != null) {
			System.out.println("Message:" + jsonRpcResponse.getError().getMessage());
		} else {
			System.out.println("Error has occured");
		}
		return responseObject;
	}

}
