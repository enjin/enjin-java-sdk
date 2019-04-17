package com.enjin.enjincoin.sdk.graphql;

import java.util.List;

public class GraphQLResponse<T> {

    private T data;

    private List<GraphError> errors;

    public T getData() {
        return data;
    }

    public List<GraphError> getErrors() {
        return errors;
    }

    public boolean isEmpty() {
        return data == null;
    }
}
