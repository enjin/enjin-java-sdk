package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.TokenIdFormat;

/**
 * Fragment interface used to request certain information from tokens returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Token
 */
public interface TokenFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the desired token (item) ID format.
     *
     * @param tokenIdFormat the format
     * @return this request for chaining
     */
    default T tokenIdFormat(TokenIdFormat tokenIdFormat) {
        return set("tokenIdFormat", tokenIdFormat);
    }

    /**
     * Sets the request to include state data about the token (item).
     *
     * @return this request for chaining
     * @see TokenFragmentArguments#withCreator()
     * @see TokenFragmentArguments#withTokenBlocks()
     * @see TokenFragmentArguments#withSupplyDetails()
     */
    default T withStateData() {
        return set("withStateData", true);
    }

    /**
     * Sets the request to include configuration data about the token (item).
     *
     * @return this request for chaining
     * @see TokenFragmentArguments#withMeltDetails()
     * @see TokenFragmentArguments#withMetadataUri()
     * @see TokenFragmentArguments#withTransferSettings()
     */
    default T withConfigData() {
        return set("withConfigData", true);
    }

    /**
     * Sets the request to include the block data with the token (item) when used with
     * {@link TokenFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withTokenBlocks() {
        return set("withTokenBlocks", true);
    }

    /**
     * Sets the request to include the creator with the item when used with
     * {@link TokenFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withCreator() {
        return set("withCreator", true);
    }

    /**
     * Sets the request to include the melt details with the item when used with
     * {@link TokenFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withMeltDetails() {
        return set("withMeltDetails", true);
    }

    /**
     * Sets the request to include the metadata URI with the item when used with
     * {@link TokenFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withMetadataUri() {
        return set("withMetadataURI", true);
    }

    /**
     * Sets the request to include the supply details with the item when used with
     * {@link TokenFragmentArguments#withStateData()}.
     *
     * @return this request for chaining
     */
    default T withSupplyDetails() {
        return set("withSupplyDetails", true);
    }

    /**
     * Sets the request to include the transfer settings with the item when used with
     * {@link TokenFragmentArguments#withConfigData()}.
     *
     * @return this request for chaining
     */
    default T withTransferSettings() {
        return set("withTransferSettings", true);
    }

    /**
     * Sets the request to include the variant mode with the item.
     *
     * @return this request for chaining
     */
    default T withTokenVariantMode() {
        return set("withTokenVariantMode", true);
    }

    /**
     * Sets the request to include the variants with the item.
     *
     * @return this request for chaining
     */
    default T withTokenVariants() {
        return set("withTokenVariants", true);
    }

    /**
     * Sets the request to include the metadata for the variant(s) with the item when used with
     * {@link TokenFragmentArguments#withTokenVariants()}.
     *
     * @return this request for chaining
     */
    default T withVariantMetadata() {
        return set("withVariantMetadata", true);
    }

}
