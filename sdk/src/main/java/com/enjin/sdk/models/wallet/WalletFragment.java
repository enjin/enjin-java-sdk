package com.enjin.sdk.models.wallet;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.balance.BalanceFragment;
import com.enjin.sdk.models.token.TokenFragment;

public interface WalletFragment<T extends GraphQLVariableHolder<T>>
        extends GraphQLVariableHolder<T>, BalanceFragment<T>, TokenFragment<T> {

    default T balAppId(int val) {
        set("balAppId", val);
        return (T) this;
    }

    default T balTokenId(String val) {
        set("balTokenId", val);
        return (T) this;
    }

    default T balVal(int val) {
        set("balVal", val);
        return (T) this;
    }

    default T balGt(int val) {
        set("balGt", val);
        return (T) this;
    }

    default T balGte(int val) {
        set("balGte", val);
        return (T) this;
    }

    default T balLt(int val) {
        set("balLt", val);
        return (T) this;
    }

    default T balLte(int val) {
        set("balLte", val);
        return (T) this;
    }

    default T withBalances() {
        set("withBalances", true);
        return (T) this;
    }

    default T withTokensCreated() {
        set("withTokensCreated", true);
        return (T) this;
    }

}
