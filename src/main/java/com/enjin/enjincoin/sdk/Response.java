package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.graphql.GraphError;

import java.util.List;

public class Response<T> {

    private int              code;
    private T                body;
    private List<GraphError> errors;

    public Response(int code, List<GraphError> errors) {
        this(code, null, errors);
    }

    public Response(int code, T body) {
        this(code, body, null);
    }

    public Response(int code, T body, List<GraphError> errors) {
        this.code = code;
        this.body = body;
        this.errors = errors;
    }

    public int code() {
        return code;
    }

    public T body() {
        return body;
    }

    public List<GraphError> errors() {
        return this.errors;
    }

    public boolean isSuccess() {
        return body != null;
    }
}
