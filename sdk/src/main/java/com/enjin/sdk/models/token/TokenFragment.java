package com.enjin.sdk.models.token;

import com.enjin.sdk.graphql.GraphQLVariableHolder;

public interface TokenFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T> {

    default T tokenIdFormat(String val) {
        set("tokenIdFormat", val);
        return (T) this;
    }

    default T replaceUriParams() {
        set("replaceUriParams", true);
        return (T) this;
    }

    default T withTokenIndex() {
        set("withTokenIndex", true);
        return (T) this;
    }

    default T withCreator() {
        set("withCreator", true);
        return (T) this;
    }

    default T withTokenBlocks() {
        set("withTokenBlocks", true);
        return (T) this;
    }

    default T withTokenIcon() {
        set("withTokenIcon", true);
        return (T) this;
    }

    default T withMeltDetails() {
        set("withMeltDetails", true);
        return (T) this;
    }

    default T withDeleteStatus() {
        set("withDeleteStatus", true);
        return (T) this;
    }

    default T withSupplyDetails() {
        set("withSupplyDetails", true);
        return (T) this;
    }

    default T withTransferSettings() {
        set("withTransferSettings", true);
        return (T) this;
    }

    default T withItemUri() {
        set("withItemUri", true);
        return (T) this;
    }

    default T withTokenTimestamps() {
        set("withTokenTimestamps", true);
        return (T) this;
    }

}
