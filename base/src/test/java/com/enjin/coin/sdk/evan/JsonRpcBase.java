package com.enjin.coin.sdk.evan;

import com.enjin.coin.sdk.util.ContentType;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class JsonRpcBase extends WireMockBase {

    public static final int READ_TIMEOUT = 2500;
    public static final int CONNECT_TIMEOUT = 1000;

    protected JSONRPC2SessionOptions createSessionOptions() {
        JSONRPC2SessionOptions options = new JSONRPC2SessionOptions();
        options.setReadTimeout(READ_TIMEOUT);
        options.setConnectTimeout(CONNECT_TIMEOUT);
        options.ignoreVersion(true);
        options.trustAllCerts(true);
        options.setRequestContentType(ContentType.TEXT_JSON);
        options.setAllowedResponseContentTypes(new String[]{ContentType.TEXT_JSON, ContentType.APPLICATION_JSON, ContentType.APPLICATION_JSON_RPC});
        return options;
    }

    protected JSONRPC2Session createSession(String url) {
        JSONRPC2Session session = null;
        try {
            session = new JSONRPC2Session(new URL(url));
            session.setOptions(createSessionOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return session;
    }

    protected JSONRPC2Request createRequest(String method, Map<String, Object> params, Object id) {
        return new JSONRPC2Request(method, params, id);
    }

}
