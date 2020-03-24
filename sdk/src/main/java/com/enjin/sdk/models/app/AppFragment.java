package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.models.identity.IdentityFragment;

public interface AppFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T>, IdentityFragment<T> {

    default T withSecret() {
        set("withSecret", true);
        return (T) this;
    }

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

    default T withCurrentUserIdentity() {
        set("withCurrentUserIdentity", true);
        return (T) this;
    }

    default T withOwner() {
        set("withOwner", true);
        return (T) this;
    }

    default T withTokenCount() {
        set("withTokenCount", true);
        return (T) this;
    }

    default T withAppTimestamps() {
        set("withAppTimestamps", true);
        return (T) this;
    }

}
