package com.enjin.sdk.models.token;

import com.enjin.sdk.graphql.GraphQLVariableHolder;
import com.enjin.sdk.services.token.TokensService;

/**
 * A fragment interface used to include information in a request on the Trusted Platform.
 *
 * @see TokensService
 * @param <T> the super type of the interface
 */
public interface TokenFragment<T extends GraphQLVariableHolder<T>> extends GraphQLVariableHolder<T> {

    /**
     * Sets the format to render the token id in the response.
     *
     * @param val the token id format
     * @return    this request
     */
    default T tokenIdFormat(String val) {
        set("tokenIdFormat", val);
        return (T) this;
    }

    /**
     * Sets the request to replace the id and index parameters of the metadata url in the response.
     *
     * @return this request
     */
    default T replaceUriParams() {
        set("replaceUriParams", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's index in the response.
     *
     * @return this request
     */
    default T withTokenIndex() {
        set("withTokenIndex", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's creator in the response.
     *
     * @return this request
     */
    default T withCreator() {
        set("withCreator", true);
        return (T) this;
    }

    /**
     * Sets the request to to include info on the token's blocks in the response.
     *
     * @return this request
     */
    default T withTokenBlocks() {
        set("withTokenBlocks", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's item icon url in the response.
     *
     * @return this request
     */
    default T withTokenIcon() {
        set("withTokenIcon", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's melt details in the response.
     *
     * @return this request
     */
    default T withMeltDetails() {
        set("withMeltDetails", true);
        return (T) this;
    }

    /**
     * Sets the request to include if the token is marked for deletion in the response.
     *
     * @return this request
     */
    default T withDeleteStatus() {
        set("withDeleteStatus", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's supply details in the response.
     *
     * @return this request
     */
    default T withSupplyDetails() {
        set("withSupplyDetails", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's transfer settings in the response.
     *
     * @return this request
     */
    default T withTransferSettings() {
        set("withTransferSettings", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's item uri in the response, if set.
     *
     * @return this request
     */
    default T withItemUri() {
        set("withItemUri", true);
        return (T) this;
    }

    /**
     * Sets the request to include the token's timestamps in the response.
     *
     * @return this request
     */
    default T withTokenTimestamps() {
        set("withTokenTimestamps", true);
        return (T) this;
    }

}
