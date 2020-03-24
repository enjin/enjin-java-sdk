package com.enjin.sdk.models.balance;

import com.enjin.sdk.graphql.GraphQLVariableHolder;

public interface BalanceFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T> {

    default T balIdFormat(String val) {
        set("balIdFormat", val);
        return (T) this;
    }

    default T balIndexFormat(String val) {
        set("balIndexFormat", val);
        return (T) this;
    }

}
