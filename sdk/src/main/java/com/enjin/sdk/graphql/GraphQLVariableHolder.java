package com.enjin.sdk.graphql;

public interface GraphQLVariableHolder<T> {

    T set(String key, Object value);

}
