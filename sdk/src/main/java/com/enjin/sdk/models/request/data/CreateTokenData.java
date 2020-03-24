package com.enjin.sdk.models.request.data;

import com.enjin.sdk.models.request.TokenTransferFeeSettingsInput;
import com.enjin.sdk.models.token.TokenSupplyModel;
import com.enjin.sdk.models.token.TokenTransferable;

import com.enjin.sdk.services.request.RequestsService;
import lombok.Builder;

/**
 * A data model for the Create Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class CreateTokenData {

    /**
     * The name of the token.
     *
     * -- SETTER --
     *
     * @param name the token name.
     * @return the builder.
     */
    private String name;

    /**
     * The total supply.
     *
     * -- SETTER --
     *
     * @param totalSupply the total supply.
     * @return the builder.
     */
    private Integer totalSupply;

    /**
     * The initial reserve.
     *
     * -- SETTER --
     *
     * @param initialReserve the initial reserve.
     * @return the builder.
     */
    private Integer initialReserve;

    /**
     * The supply model to use.
     *
     * -- SETTER --
     *
     * @param supplyModel the supply model.
     * @return the builder.
     */
    private TokenSupplyModel supplyModel;

    /**
     * The melt value.
     *
     * -- SETTER --
     *
     * @param meltValue the melt value.
     * @return the builder.
     */
    private String meltValue;

    /**
     * The melt fee ratio.
     *
     * -- SETTER --
     *
     * @param meltFeeRatio the melt fee ratio.
     * @return the builder.
     */
    private Integer meltFeeRatio;

    /**
     * Whether the token is transferable or not.
     *
     * -- SETTER --
     *
     * @param transferable the type.
     * @return the builder.
     */
    private TokenTransferable transferable;

    /**
     * The transfer fee settings.
     *
     * -- SETTER --
     *
     * @param transferFeeSettings the settings.
     * @return the builder.
     */
    private TokenTransferFeeSettingsInput transferFeeSettings;

    /**
     * Whether the toke is fungible or non-fungible.
     *
     * -- SETTER --
     *
     * @param nonFungible is it a non-fungible?
     * @return the builder.
     */
    private Boolean nonFungible;

    private String icon;

}
