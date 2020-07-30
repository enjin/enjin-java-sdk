package com.enjin.sdk.schemas.shared.fragments.inputs;

import com.enjin.sdk.graphql.VariableHolder;

/**
 * TODO
 */
public interface TokenFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @param tokenIdFormat
     * @return
     */
    default T tokenIdFormat(TokenIdFormat tokenIdFormat) {
        return set("tokenIdFormat", tokenIdFormat);
    }

    /**
     * TODO
     * @return
     */
    default T withTokenBlocks() {
        return set("withTokenBlocks", true);
    }

    /**
     * TODO
     * @return
     */
    default T withCreator() {
        return set("withCreator", true);
    }

    /**
     * TODO
     * @return
     */
    default T withMeltDetails() {
        return set("withMeltDetails", true);
    }

    /**
     * TODO
     * @return
     */
    default T withMetadataUri() {
        return set("withMetadataUri", true);
    }

    /**
     * TODO
     * @return
     */
    default T withSupplyDetails() {
        return set("withSupplyDetails", true);
    }

    /**
     * TODO
     * @return
     */
    default T withTransferSettings() {
        return set("withTransferSettings", true);
    }

    /**
     * TODO
     * @return
     */
    default T withTokenVariantMode() {
        return set("withTokenVariantMode", true);
    }

    /**
     * TODO
     * @return
     */
    default T withTokenVariants() {
        return set("withTokenVariants", true);
    }

}
