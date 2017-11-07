package com.enjin.coin.sdk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.enjin.coin.sdk.util.Constants;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;
import com.thetransactioncompany.jsonrpc2.client.RawResponse;
import com.thetransactioncompany.jsonrpc2.client.RawResponseInspector;

public class Identities {

	public static void main(String args[]) {
		String identitiesStr = Identities.getIdentities();
		System.out.println("identitiesStr:" + identitiesStr);
	}
	
	
	public static final String getIdentities() {

		String responseString = null;
		
		// Creating a new session to a JSON-RPC 2.0 web service at a specified URL

		// The JSON-RPC 2.0 server URL
		URL serverURL = null;

		try {
			serverURL = new URL(Constants.IDENTITIES_URL);

		} catch (MalformedURLException e) {
			System.out.println("A MalformedURLException has occured. Exception: " + e);
			return responseString;
		}

		// Create new JSON-RPC 2.0 client session
		JSONRPC2Session mySession = new JSONRPC2Session(serverURL);
		mySession.getOptions().setRequestContentType(Constants.TYPE_JSON_RPC);

		// Once the client session object is created, you can use to send a series
		// of JSON-RPC 2.0 requests and notifications to it.

		// The required parameters to pass
		Map<String,Object> identityMap = new HashMap<String,Object>();
		identityMap.put("identity_id", "123456");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth", "xxxxxxx");
		params.put("identity", identityMap);

		// Construct new request
		String method = "Identities.get";
		int requestID = 1;
		JSONRPC2Request jsonRpcRequest = new JSONRPC2Request(method, params, requestID);
		System.out.println("jsonRpcRequest:"+jsonRpcRequest);
		// Send request
		JSONRPC2Response jsonRpcResponse = null;

		try {
			jsonRpcResponse = mySession.send(jsonRpcRequest);

		} catch (JSONRPC2SessionException e) {
			System.out.println("A JSONRPC2SessionException has occured. Exception: " + e);
			return responseString;
		}

		// Print response result / error
		if (jsonRpcResponse != null && jsonRpcResponse.indicatesSuccess()) {
			responseString = jsonRpcResponse.getResult().toString();
		} else if (jsonRpcResponse != null) {
			System.out.println("Message:" + jsonRpcResponse.getError().getMessage());
		} else {
			System.out.println("Error has occured");
		}

		return responseString;

	}
}
