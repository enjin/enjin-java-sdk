package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.wallet.WalletFragment;

public interface IdentityFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T>, WalletFragment<T> {

    default T withLinkingCode() {
        set("withLinkingCode", true);
        return (T) this;
    }

    default T withLinkingCodeQr() {
        set("withLinkingCodeQr", true);
        return (T) this;
    }

    default T linkingCodeQrSize(int val) {
        set("linkingCodeQrSize", val);
        return (T) this;
    }

    default T withWallet() {
        set("withWallet", true);
        return (T) this;
    }

    default T withIdentityTimestamps() {
        set("withIdentityTimestamps", true);
        return (T) this;
    }

}
